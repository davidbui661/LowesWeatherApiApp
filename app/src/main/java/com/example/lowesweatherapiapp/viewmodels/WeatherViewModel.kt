package com.example.lowesweatherapiapp.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lowesweatherapiapp.data.models.HourlyWeatherDTO
import com.example.lowesweatherapiapp.data.models.WeatherResponseDTO
import com.example.lowesweatherapiapp.data.repos.WeatherRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.Exception

class WeatherViewModel: ViewModel() {

    private val weatherRepo: WeatherRepository by lazy { WeatherRepository }

    private var _weatherList: MutableLiveData<WeatherResponseDTO> = MutableLiveData()
    val weatherList: LiveData<WeatherResponseDTO> get() = _weatherList

    private var _errorMessage: MutableLiveData<String> = MutableLiveData()
    val errorMessage: LiveData<String> get() = _errorMessage

    private var _progressIsVisible: MutableLiveData<Boolean> = MutableLiveData()
    val progressIsVisible: LiveData<Boolean> get() = _progressIsVisible

    private var _navigateToHourlyFragment: MutableLiveData<Boolean> = MutableLiveData()
    val navigateToHourlyFragment: LiveData<Boolean> get() = _navigateToHourlyFragment

    var hourlyWeather : HourlyWeatherDTO? = null
    var cityName = " "

    fun getWeather(cityName: String) {
        if (cityName.isNotBlank()) {
            this.cityName = cityName
            _progressIsVisible.value = true
            viewModelScope.launch(Dispatchers.IO) {
                try {
                    val weather = weatherRepo.getWeather(cityName).body()

                    if(weather?.list.isNullOrEmpty()){
                       _errorMessage.postValue("No weather")
                    }else{
                        _navigateToHourlyFragment.postValue(true)
                        _weatherList.postValue(weather)
                        _errorMessage.postValue(null)
                    }

                    _progressIsVisible.postValue(false)
                } catch (e: Exception) {
                    _errorMessage.postValue("Something went wrong...")
                    _progressIsVisible.postValue(false)
                }
            }
        } else {
            _errorMessage.value = "Enter city name in search"
        }
    }

    fun shouldNavigate(shouldNavigate: Boolean) {
        _navigateToHourlyFragment.postValue(shouldNavigate)
    }

    companion object {
        private val TAG = WeatherViewModel::class.java.name
    }
}
package com.example.lowesweatherapiapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.NavHostFragment
import com.bumptech.glide.Glide
import com.example.lowesweatherapiapp.R
import com.example.lowesweatherapiapp.databinding.DetailsFragmentBinding
import com.example.lowesweatherapiapp.utils.loadImage
import com.example.lowesweatherapiapp.utils.updateSupportBar
import com.example.lowesweatherapiapp.viewmodels.WeatherViewModel

class WeatherDetailsFragment : Fragment() {
    private var binding: DetailsFragmentBinding? = null

    private val weatherViewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = DetailsFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        updateSupportBar(weatherViewModel.cityName,
            AppCompatResources.getDrawable(requireContext(), R.drawable.ic_outline_arrow_back_24))

        binding?.let { v ->

            v.currentTemp.text = weatherViewModel.hourlyWeather?.main?.temp?.toInt().toString()
            v.feelsLike.text = String.format(
                getString(R.string.feels_like),
                weatherViewModel.hourlyWeather?.main?.feelsLike?.toInt().toString()
            )
            v.weatherMain.text = weatherViewModel.hourlyWeather?.weather?.get(0)?.main
            v.weatherDescription.text = weatherViewModel.hourlyWeather?.weather?.get(0)?.description

            val imageUrl =
                "https://openweathermap.org/img/wn/${weatherViewModel.hourlyWeather?.weather?.elementAt(
                    0)?.icon}.png"
            v.weatherImage.loadImage(imageUrl)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
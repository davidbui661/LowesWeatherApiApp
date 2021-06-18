package com.example.lowesweatherapiapp.data.remote.network
import com.example.lowesweatherapiapp.data.models.WeatherResponseDTO
import retrofit2.Response

class WeatherManager {

    private val service: WeatherService
    private val retrofit = RetrofitService.providesRetrofitService()

    init {
        service = retrofit.create(WeatherService::class.java)
    }

    suspend fun getWeather(q: String, appId: String, unit: String) : Response<WeatherResponseDTO> {
        return service.getWeather(q, appId, unit)
    }
}
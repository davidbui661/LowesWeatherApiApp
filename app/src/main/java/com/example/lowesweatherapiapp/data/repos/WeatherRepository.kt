package com.example.lowesweatherapiapp.data.repos

import com.example.lowesweatherapiapp.data.models.WeatherResponseDTO
import com.example.lowesweatherapiapp.data.remote.network.WeatherManager
import com.example.lowesweatherapiapp.constants.UNITS
import com.example.lowesweatherapiapp.constants.API_KEY
import retrofit2.Response

object WeatherRepository {

    private val weatherManager: WeatherManager by lazy { WeatherManager() }

    suspend fun getWeather(q: String): Response<WeatherResponseDTO> {
        return weatherManager.getWeather(
            q,
            API_KEY,
            UNITS)
    }
}
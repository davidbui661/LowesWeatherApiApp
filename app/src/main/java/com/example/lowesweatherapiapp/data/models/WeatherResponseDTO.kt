package com.example.lowesweatherapiapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherResponseDTO(
    @field:Json(name = "city")val city: CityDTO?,
    @field:Json(name = "cnt")val cnt: Int?,
    @field:Json(name = "cod")val cod: String?,
    @field:Json(name = "list")val list: List<HourlyWeatherDTO>,
    @field:Json(name = "message")val message: Int?
)

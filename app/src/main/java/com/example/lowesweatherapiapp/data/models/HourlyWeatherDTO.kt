package com.example.lowesweatherapiapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class HourlyWeatherDTO(
    @field:Json(name = "clouds") val clouds: CloudsDTO?,
    @field:Json(name = "dt") val dt: Int?,
    @field:Json(name = "dt_txt") val dtTxt: String?,
    @field:Json(name = "main") val main: MainDTO?,
    @field:Json(name = "pop") val pop: Double?,
    @field:Json(name = "rain") val rain: RainDTO?,
    @field:Json(name = "sys") val sys: SysDTO?,
    @field:Json(name = "visibility") val visibility: Int?,
    @field:Json(name = "weather") val weather: List<WeatherDTO>,
    @field:Json(name = "wind") val wind: WindDTO?
)

package com.example.lowesweatherapiapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WeatherDTO(
    @field:Json(name = "description") val description: String?,
    @field:Json(name = "icon") val icon: String,
    @field:Json(name = "id") val id: Int?,
    @field:Json(name = "main") val main: String?
)

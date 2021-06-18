package com.example.lowesweatherapiapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class WindDTO(
    @field:Json(name = "deg") val deg: Int?,
    @field:Json(name = "gust") val gust: Double?,
    @field:Json(name = "speed") val speed: Double?
)

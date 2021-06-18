package com.example.lowesweatherapiapp.data.models

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SysDTO(
    @field:Json(name = "pod") val pod: String?
)

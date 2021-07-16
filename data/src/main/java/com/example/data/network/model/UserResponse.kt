package com.example.data.network.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserResponse(
    @Json(name = "userId")
    val userId: String,
    @Json(name = "firsname")
    val firstname: String,
    @Json(name = "lastname")
    val lastname: String,
    @Json(name = "email")
    val email: String
)
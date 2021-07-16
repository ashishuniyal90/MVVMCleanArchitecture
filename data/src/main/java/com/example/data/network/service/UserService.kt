package com.example.data.network.service

import com.example.data.network.model.UserResponse
import retrofit2.http.GET

interface UserService {

    @GET("users")
    suspend fun getAllUsers(): List<UserResponse>
}
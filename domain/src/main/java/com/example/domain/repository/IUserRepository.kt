package com.example.domain.repository

import com.example.domain.model.Resource
import com.example.domain.model.User

interface IUserRepository {

    suspend fun getAllUsers(): Resource<List<User>>
}
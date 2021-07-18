package com.example.data.repository

import com.example.data.mappers.UserMapper
import com.example.data.network.service.UserService
import com.example.domain.model.User
import com.example.domain.repository.IUserRepository

class UserRepository(
    private val userService: UserService
) : BaseRepository(), IUserRepository {

    override suspend fun getAllUsers(): List<User> {
        val response = execute {
            userService.getAllUsers()
        }
        return response.map {
            UserMapper.map(it)
        }
    }

}

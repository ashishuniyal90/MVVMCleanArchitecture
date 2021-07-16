package com.example.data.repository

import com.example.data.mappers.UserMapper
import com.example.data.network.service.UserService
import com.example.domain.model.Resource
import com.example.domain.model.User
import com.example.domain.repository.IUserRepository

class UserRepository(
    private val userService: UserService
) : BaseRepository(), IUserRepository {

    override suspend fun getAllUsers(): Resource<List<User>> {
        val response = execute {
            userService.getAllUsers()
        }
        return when (response) {
            is Resource.Success -> {
                Resource.Success(response.data.map {
                    UserMapper.map(it)
                })
            }
            is Resource.Error -> {
                Resource.Error(response.error)
            }
        }

    }

}
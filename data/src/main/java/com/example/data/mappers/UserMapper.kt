package com.example.data.mappers

import com.example.data.network.model.UserResponse
import com.example.domain.model.User

object UserMapper : Mapper<UserResponse, User> {
    override fun map(input: UserResponse): User {
        return User(
            userId = input.userId,
            firstname = input.firstname,
            lastname = input.lastname,
            email = input.email
        )
    }
}
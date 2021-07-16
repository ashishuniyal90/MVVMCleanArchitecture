package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.IUserRepository

class GetAllUsersAsyncUseCase(
    private val userRepository: IUserRepository
) : BaseAsyncUseCase<Unit, List<User>>() {

    override suspend fun createSuspend(data: Unit) = userRepository.getAllUsers()
}
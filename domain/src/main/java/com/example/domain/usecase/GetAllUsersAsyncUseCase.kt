package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.IUserRepository

class GetAllUsersAsyncUseCase(
    private val userRepository: IUserRepository
) : FlowUseCase<Unit, List<User>>() {
    override suspend fun run(params: Unit) = userRepository.getAllUsers()

}

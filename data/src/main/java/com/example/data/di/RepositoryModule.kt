package com.example.data.di

import com.example.data.repository.UserRepository
import com.example.domain.repository.IUserRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<IUserRepository> { UserRepository(get()) }
}

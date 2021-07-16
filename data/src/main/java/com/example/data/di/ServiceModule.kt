package com.example.data.di

import com.example.data.network.service.UserService
import org.koin.dsl.module
import retrofit2.Retrofit

val serviceModule = module {

    single { provideService<UserService>(get()) }
}

private inline fun <reified T> provideService(retrofit: Retrofit) = retrofit.create(T::class.java)
package com.example.cleanarchitecture_mvvm

import android.app.Application
import com.example.cleanarchitecture_mvvm.di.viewModelModule
import com.example.data.di.networkModule
import com.example.data.di.repositoryModule
import com.example.data.di.serviceModule
import com.example.domain.di.useCaseModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CleanArchitectureApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@CleanArchitectureApp)
            modules(
                listOf(
                    networkModule,
                    viewModelModule,
                    repositoryModule,
                    useCaseModule,
                    serviceModule
                )
            )
        }
    }
}

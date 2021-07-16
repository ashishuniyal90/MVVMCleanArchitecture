package com.example.cleanarchitecture_mvvm.di

import com.example.cleanarchitecture_mvvm.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {

    viewModel { MainViewModel(get()) }
}
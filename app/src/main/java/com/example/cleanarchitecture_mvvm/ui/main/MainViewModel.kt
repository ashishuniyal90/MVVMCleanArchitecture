package com.example.cleanarchitecture_mvvm.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.model.onFailure
import com.example.domain.model.onSuccess
import com.example.domain.usecase.GetAllUsersAsyncUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class MainViewModel(private val usersUseCase: GetAllUsersAsyncUseCase) : ViewModel() {

    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>>
        get() = _userList

    init {


        launch {
            usersUseCase(Unit)
                .onSuccess {
                    _userList.value = it
                }
                .onFailure {
                    println("Inside Error =============")
                }
        }
    }
}


inline fun ViewModel.launch(
    coroutineContext: CoroutineContext = Dispatchers.Main,
    crossinline block: suspend CoroutineScope.() -> Unit
): Job {
    return viewModelScope.launch(coroutineContext) { block() }
}
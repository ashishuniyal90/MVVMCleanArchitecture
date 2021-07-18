package com.example.cleanarchitecture_mvvm.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.GetAllUsersAsyncUseCase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModel(private val usersUseCase: GetAllUsersAsyncUseCase) : ViewModel() {

    private val _userList = MutableStateFlow<List<User>>(emptyList())
    val userList: StateFlow<List<User>>
        get() = _userList

    init {
            usersUseCase(Unit)
                .catch { e ->
                    // parse exception to ui events
                    println(" there was a error do something")
                }
                .collectIn(viewModelScope) {
                    _userList.value = it
                }
        }
}

inline fun <T> Flow<T>.collectIn(scope: CoroutineScope, crossinline action: suspend (value: T) -> Unit): Job =
    scope.launch {
        collect {
            action.invoke(it)
        }
    }

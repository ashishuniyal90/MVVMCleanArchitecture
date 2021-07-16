package com.example.data.repository

import com.example.domain.model.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    protected suspend fun <T : Any> execute(call: suspend () -> T) = withContext(Dispatchers.IO) {
        try {
            Resource.Success(call())
        } catch (ex: Throwable) {
            Resource.Error(ex)
        }
    }
}
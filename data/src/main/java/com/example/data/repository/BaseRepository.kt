package com.example.data.repository

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

open class BaseRepository {

    protected suspend fun <T> execute(call: suspend () -> T): T = withContext(Dispatchers.IO) {
        try {
            call()
        } catch (ex: Exception) {
            throw parseException(ex)
        }
    }
}

/**
 * parse the system exception to user familiar exception
 * like IOException to NoNetworkException
 */
fun parseException(exception: Exception): Exception {
    return exception
}


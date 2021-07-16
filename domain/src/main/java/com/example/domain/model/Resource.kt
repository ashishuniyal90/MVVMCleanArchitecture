package com.example.domain.model

/**
 * Resource
 *
 * Wrapper class for data/errors passed to the app layer
 */
sealed class Resource<out T : Any> {

    /**
     * Represents a successful retrieval.
     */
    data class Success<out T : Any>(val data: T) : Resource<T>()

    /**
     * Represents a failed retrieval.
     */
    data class Error(val error: Throwable) :
        Resource<Nothing>()
}


inline fun <T : Any> Resource<T>.onSuccess(action: (T) -> Unit): Resource<T> {
    if (this is Resource.Success) action(data)
    return this
}

inline fun <T : Any> Resource<T>.onFailure(action: (Throwable) -> Unit) {
    if (this is Resource.Error) action(error)
}
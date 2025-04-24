package com.example.todoappwithjetpack.utility

sealed class RequestState<out T> {
    object Idle : RequestState<Nothing>()
    object Loading : RequestState<Nothing>()
    data class Success<T>(val data: T) : RequestState<T>()
    data class Error<out T>(val error: Throwable): RequestState<T>()
}
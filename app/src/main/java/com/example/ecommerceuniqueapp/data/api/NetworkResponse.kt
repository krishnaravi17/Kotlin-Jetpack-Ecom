package com.example.ecommerceuniqueapp.data.api

sealed class NetworkResponse<out T> {
    data class Success<out T>(val data: T) : NetworkResponse<T>()
    data class Failure(val msg: String) : NetworkResponse<Nothing>()
    object Loading : NetworkResponse<Nothing>()
}
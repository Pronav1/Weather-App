package com.pranavpandey.wheatherapp.api

sealed class NetworkResponse <out t>{
 data class Success<out T>(val data: T): NetworkResponse<T>()
    data class Error(val message: String): NetworkResponse<Nothing>()
    object Loding: NetworkResponse<Nothing>()

}
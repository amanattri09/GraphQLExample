package com.example.graphqlexample.data.common

sealed class ApiResponse<out T>{

    object Loading : ApiResponse<Nothing>()

    class Error constructor(val error : Throwable) : ApiResponse<Nothing>()

    class Success<out T>(val data : T) : ApiResponse<T>()

}

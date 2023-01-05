package com.example.graphqlexample.data.common

import com.example.graphqlexample.common.network.NetworkException

fun Any?.isValidate(): Any {
    return this ?: throw NetworkException()
}
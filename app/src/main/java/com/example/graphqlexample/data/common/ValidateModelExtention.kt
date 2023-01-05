package com.example.graphqlexample.data.common

import com.example.graphqlexample.common.network.NetworkException

fun <T> T?.isValidate(): T {
    return this ?: throw NetworkException()
}
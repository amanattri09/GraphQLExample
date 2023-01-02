package com.example.graphqlexample.common.network

import com.example.graphqlexample.data.remote.capsule.entities.CapsulesResponse

interface IGqlApiService {
    suspend fun getCapsules() : CapsulesResponse
}
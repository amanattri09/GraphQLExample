package com.example.composeexamplev3.domain.post

import com.example.graphqlexample.data.remote.capsule.entities.CapsulesResponse
import kotlinx.coroutines.flow.Flow

interface ICapsuleRepositary {
    suspend fun getCapsules() : Flow<CapsulesResponse>
}
package com.example.composeexamplev3.domain.post

import com.example.FindCapsulesQuery
import kotlinx.coroutines.flow.Flow

interface ICapsuleRepositary {
    suspend fun getCapsules() : Flow<FindCapsulesQuery.Data?>
}
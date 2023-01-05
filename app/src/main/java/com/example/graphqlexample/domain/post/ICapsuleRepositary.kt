package com.example.composeexamplev3.domain.post

import com.example.FindCapsulesQuery
import com.example.graphqlexample.domain.post.models.CapsuleModel
import kotlinx.coroutines.flow.Flow

interface ICapsuleRepositary {
    suspend fun getCapsules() : Flow<List<CapsuleModel?>?>
}
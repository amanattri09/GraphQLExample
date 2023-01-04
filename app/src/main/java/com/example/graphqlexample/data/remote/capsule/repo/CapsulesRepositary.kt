package com.example.graphqlexample.data.remote.capsule.repo

import com.example.FindCapsulesQuery
import com.example.composeexamplev3.domain.post.ICapsuleRepositary
import com.example.graphqlexample.common.network.GqlApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CapsulesRepositary @Inject constructor(private val gqlService: GqlApiService) : ICapsuleRepositary {
    override suspend fun getCapsules(): Flow<FindCapsulesQuery.Data?> {
        return flow {
            emit(gqlService.getCapsules().data)
        }
    }
}
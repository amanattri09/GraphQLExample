package com.example.graphqlexample.data.remote.capsule.repo

import com.example.composeexamplev3.domain.post.ICapsuleRepositary
import com.example.graphqlexample.common.network.GqlApiService
import com.example.graphqlexample.data.remote.capsule.toCapsuleModel
import com.example.graphqlexample.domain.post.models.CapsuleModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CapsulesRepositary @Inject constructor(private val gqlService: GqlApiService) :
    ICapsuleRepositary {
    override suspend fun getCapsules(): Flow<List<CapsuleModel?>?> {
        return flow {
            emit(gqlService.getCapsules().data)
        }.map {
            it?.capsules
        }.map {
            it?.map {
                it?.toCapsuleModel()
            }
        }.flowOn(Dispatchers.Default)
    }
}
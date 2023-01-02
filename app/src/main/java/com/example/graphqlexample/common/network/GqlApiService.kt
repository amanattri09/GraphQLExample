package com.example.graphqlexample.common.network

import com.apollographql.apollo3.ApolloClient
import com.example.graphqlexample.data.remote.capsule.entities.CapsulesResponse
import javax.inject.Inject

class GqlApiService @Inject constructor(private val apolloClient: ApolloClient): IGqlApiService{

    override suspend fun getCapsules(): CapsulesResponse {
       TODO()
    }

}
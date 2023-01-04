package com.example.graphqlexample.common.network

import com.apollographql.apollo3.api.ApolloResponse
import com.example.FindCapsulesQuery

interface IGqlApiService {
    suspend fun getCapsules() : ApolloResponse<FindCapsulesQuery.Data>
}
package com.example.graphqlexample.common.network

import com.apollographql.apollo3.api.ApolloResponse
import com.example.CharactersQuery

interface IGqlApiService {
    suspend fun getChracters() : ApolloResponse<CharactersQuery.Data>
}
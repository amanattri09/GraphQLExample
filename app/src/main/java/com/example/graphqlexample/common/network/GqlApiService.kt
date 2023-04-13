package com.example.graphqlexample.common.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.CharactersQuery
import javax.inject.Inject

class GqlApiService @Inject constructor(private val apolloClient: ApolloClient): IGqlApiService{
    override suspend fun getChracters(): ApolloResponse<CharactersQuery.Data> {
        return apolloClient.query(CharactersQuery()).execute()
    }


}
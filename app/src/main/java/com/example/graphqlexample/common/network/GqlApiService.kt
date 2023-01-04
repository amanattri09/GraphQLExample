package com.example.graphqlexample.common.network

import com.apollographql.apollo3.ApolloClient
import com.apollographql.apollo3.api.ApolloResponse
import com.example.FindCapsulesQuery
import javax.inject.Inject

class GqlApiService @Inject constructor(private val apolloClient: ApolloClient): IGqlApiService{

    override suspend fun getCapsules(): ApolloResponse<FindCapsulesQuery.Data> {
       return apolloClient.query(FindCapsulesQuery()).execute()
    }

}
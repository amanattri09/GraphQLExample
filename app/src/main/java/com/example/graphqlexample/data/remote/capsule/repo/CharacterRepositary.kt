package com.example.graphqlexample.data.remote.capsule.repo

import com.example.CharactersQuery
import com.example.composeexamplev3.domain.post.ICharacterRepositary
import com.example.graphqlexample.common.network.GqlApiService
import com.example.graphqlexample.data.remote.capsule.toModel
import com.example.graphqlexample.domain.capsule.models.CharacterModel
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class CharacterRepositary @Inject constructor(private val gqlService: GqlApiService) :
    ICharacterRepositary {
    //    override suspend fun getCapsules(): Flow<List<CharacterModel?>?> {
//        return flow {
//            emit(gqlService.getCapsules().data)
//        }.map {
//            it?.characters
//        }.map { it ->
//            it?.m {
//                it?.toCapsuleModel()
//            }
//        }.flowOn(Dispatchers.Default)
//    }
    override suspend fun getCharacters(): Flow<List<CharacterModel?>?> {
        return flow {
            emit(gqlService.getChracters().data)
        }.map {
            it?.characters
        }.map {
            it?.results?.map {
                it?.toModel()
            }
        }
    }


}

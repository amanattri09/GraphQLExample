package com.example.composeexamplev3.domain.post

import com.example.graphqlexample.domain.capsule.models.CharacterModel
import kotlinx.coroutines.flow.Flow

interface ICharacterRepositary {
    suspend fun getCharacters() : Flow<List<CharacterModel?>?>
}
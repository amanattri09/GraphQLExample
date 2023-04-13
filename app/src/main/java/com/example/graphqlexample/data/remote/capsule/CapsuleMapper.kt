package com.example.graphqlexample.data.remote.capsule

import com.example.CharactersQuery
import com.example.graphqlexample.domain.capsule.models.CharacterModel



fun CharactersQuery.Result?.toModel(): CharacterModel {
    return CharacterModel(this?.name)
}

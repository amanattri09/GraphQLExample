package com.example.graphqlexample.data.remote.capsule

import com.example.FindCapsulesQuery
import com.example.graphqlexample.domain.post.models.CapsuleModel

fun FindCapsulesQuery.Capsule.toCapsuleModel(): CapsuleModel{
    return CapsuleModel(this.id)
}
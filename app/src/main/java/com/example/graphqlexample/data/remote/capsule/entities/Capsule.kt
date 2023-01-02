package com.example.graphqlexample.data.remote.capsule.entities

data class Capsule(
    val id: String,
    val landings: Int,
    val missions: List<Mission>,
    val status: String,
    val type: String
)
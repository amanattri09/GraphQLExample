package com.example.graphqlexample.common.di

import com.example.composeexamplev3.domain.post.ICharacterRepositary
import com.example.graphqlexample.data.remote.capsule.repo.CharacterRepositary
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositaryModule {

    @Provides
    fun providePostRepo(postRepositary: CharacterRepositary): ICharacterRepositary = postRepositary

}
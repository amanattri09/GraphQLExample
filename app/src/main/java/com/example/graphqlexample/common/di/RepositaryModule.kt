package com.example.graphqlexample.common.di

import com.example.composeexamplev3.domain.post.ICapsuleRepositary
import com.example.graphqlexample.data.remote.capsule.repo.CapsulesRepositary
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
class RepositaryModule {

    @Provides
    fun providePostRepo(postRepositary: CapsulesRepositary): ICapsuleRepositary = postRepositary

}
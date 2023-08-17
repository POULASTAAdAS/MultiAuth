package com.example.authapp.di

import com.example.authapp.data.remote.Api
import com.example.authapp.data.repository.NetworkRepositoryImpl
import com.example.authapp.domain.repository.NetworkRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkRepositoryModule {

    @Provides
    @Singleton
    fun provideNetworkRepository(api: Api): NetworkRepository = NetworkRepositoryImpl(api = api)
}
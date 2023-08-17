package com.example.authapp.data.repository

import com.example.authapp.data.remote.Api
import com.example.authapp.domain.repository.NetworkRepository
import com.example.authapp.model.AuthenticationRequest
import javax.inject.Inject

class NetworkRepositoryImpl @Inject constructor(private val api: Api) : NetworkRepository {
    override suspend fun logInUserOnBackend(authenticationRequest: AuthenticationRequest)=
        api.logInUserOnBackend(authenticationRequest = authenticationRequest)
}
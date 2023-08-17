package com.example.authapp.domain.repository

import com.example.authapp.model.ApiResponse
import com.example.authapp.model.AuthenticationRequest

interface NetworkRepository {
    suspend fun logInUserOnBackend(authenticationRequest: AuthenticationRequest) : ApiResponse
}
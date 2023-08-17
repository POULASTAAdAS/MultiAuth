package com.example.authapp.data.remote

import com.example.authapp.model.ApiResponse
import com.example.authapp.model.AuthenticationRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface Api {
    @POST("/authentication")
    suspend fun logInUserOnBackend(
        @Body authenticationRequest: AuthenticationRequest
    ): ApiResponse
}
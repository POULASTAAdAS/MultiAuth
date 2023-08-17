package com.example.authapp.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationRequest(
    val tokenID: String? = null,
    val userName: String? = null,
    val password: String? = null
)
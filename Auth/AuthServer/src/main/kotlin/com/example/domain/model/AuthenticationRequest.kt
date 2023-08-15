package com.example.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class AuthenticationRequest(
    val tokenID: String? = null,
    val userName: String? = null, // TODO can be username or email
    val password: String? = null
)
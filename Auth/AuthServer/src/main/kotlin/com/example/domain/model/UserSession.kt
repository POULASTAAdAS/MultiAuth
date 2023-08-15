package com.example.domain.model

import io.ktor.server.auth.Principal

data class UserSession(
    val password: String, // for google it will be sub and for basic it will be password
    val name: String
) : Principal

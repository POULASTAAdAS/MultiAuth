package com.example.authapp.model

import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse(val status: Boolean? = null)
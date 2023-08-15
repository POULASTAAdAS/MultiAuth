package com.example.plugins

import com.example.domain.model.EndPoint
import com.example.domain.model.UserSession
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.http.content.*
import io.ktor.server.sessions.*

fun Application.configureAuth() {
    install(Authentication) {
        session<UserSession>("auth") {
            skipWhen {
                it.sessions.get<UserSession>() != null
            }
            validate { it }

            challenge {
                call.resolveResource(EndPoint.Unauthorized.path)
            }
        }
    }
}
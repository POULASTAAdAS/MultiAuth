package com.example.route.authentication

import com.example.domain.model.EndPoint
import com.example.domain.model.UserSession
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.basicAuthentication(
    userName: String,
    password: String
) {
    // TODO database operation save user

    // TODO if database operation true.............if new create else return old

    call.sessions.set(UserSession(password = password, name = userName))

    call.respondRedirect(EndPoint.Authorized.path)
}
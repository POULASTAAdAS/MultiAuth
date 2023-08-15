package com.example.route

import com.example.domain.model.EndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.unauthorizedRoute() {
    get(EndPoint.Unauthorized.path) {
        call.respond(
            message = "not authorized!",
            status = HttpStatusCode.Unauthorized
        )
    }
}
package com.example.route

import com.example.domain.model.EndPoint
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authorizedRoute() {
    authenticate("auth") {
        get(EndPoint.Authorized.path) {
            call.respond(
                message = "auth true",
                status = HttpStatusCode.OK
            )
        }
    }
}
package com.example.plugins

import com.example.route.authorizedRoute
import com.example.route.authentication.authentication
import com.example.route.rootRoute
import com.example.route.unauthorizedRoute
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        rootRoute()
        authentication(application)
        authorizedRoute()
        unauthorizedRoute()
    }
}

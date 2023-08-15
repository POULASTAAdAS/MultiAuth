package com.example.route.authentication

import com.example.domain.model.AuthenticationRequest
import com.example.domain.model.EndPoint
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.authentication(
    app: Application
){
    post (EndPoint.Authentication.path) {
        val result = call.receive<AuthenticationRequest>()

        if (result.tokenID != null){
            googleAuthentication(result.tokenID)
        }
        else if (result.userName != null && result.password != null){

            basicAuthentication(result.userName , result.password)

        }else{
            app.log.info("error authenticating")
            call.respondRedirect(EndPoint.Unauthorized.path)
        }
    }
}
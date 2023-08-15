package com.example.route.authentication

import com.example.domain.model.EndPoint
import com.example.domain.model.UserSession
import com.example.util.Constants
import com.google.api.client.googleapis.auth.oauth2.GoogleIdToken
import com.google.api.client.googleapis.auth.oauth2.GoogleIdTokenVerifier
import com.google.api.client.http.javanet.NetHttpTransport
import com.google.api.client.json.gson.GsonFactory
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.sessions.*
import io.ktor.util.pipeline.*

suspend fun PipelineContext<Unit, ApplicationCall>.googleAuthentication(tokenId: String) {
    val result = verifyTokenId(tokenId)


    if (result != null) {
        saveUserToDatabase(application, result)
    } else {
        application.log.info("TOKEN VERIFICATION FAILED")

        call.respondRedirect(EndPoint.Unauthorized.path)
    }
}

private suspend fun PipelineContext<Unit, ApplicationCall>.saveUserToDatabase(
    app: Application,
    result: GoogleIdToken
) {
    val sub = result.payload["sub"].toString()
    val name = result.payload["name"].toString()

    // TODO database operation save user

    // TODO if database operation true.............if new create else return old

    // TODO error handling

    call.sessions.set(UserSession(password = sub, name = name))

    call.respondRedirect(EndPoint.Authorized.path)
}

fun verifyTokenId(tokenId: String): GoogleIdToken? = try {
    GoogleIdTokenVerifier.Builder(NetHttpTransport(), GsonFactory())
        .setAudience(listOf(Constants.AUDIENCE))
        .setIssuer(Constants.ISSUER)
        .build()
        .verify(tokenId)
} catch (e: Exception) {
    null
}
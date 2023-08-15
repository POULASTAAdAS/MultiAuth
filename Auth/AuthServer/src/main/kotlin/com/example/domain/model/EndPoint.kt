package com.example.domain.model

sealed class EndPoint (val path: String){
    data object Root: EndPoint(path = "/")
    data object Authentication: EndPoint(path = "/authentication")
    data object MainContent: EndPoint(path = "/main")
    data object SignOut: EndPoint(path = "/sign_out")

    data object Authorized: EndPoint(path = "/authorized")
    data object Unauthorized: EndPoint(path = "/unauthorized")
}
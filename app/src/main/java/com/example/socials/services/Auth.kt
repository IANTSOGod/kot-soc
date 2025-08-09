package com.example.socials.services

import com.example.socials.types.LoginResult
import io.ktor.client.*
import io.ktor.client.call.body
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.request.*
import io.ktor.http.HttpStatusCode
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import com.example.socials.types.Userlogin
import com.example.socials.types.ResponseOkLogin
import com.example.socials.types.ResponseBadRequest
import com.example.socials.types.ResponseErrorMessage

suspend fun login(email: String, password: String): LoginResult {
    val client = HttpClient(CIO) {
        install(ContentNegotiation) {
            json()
        }
    }
    val response = client.post("http://10.42.0.1:3000/auth/login") {
        contentType(io.ktor.http.ContentType.Application.Json)
        setBody(
            Userlogin(
                email = email,
                password = password
            )
        )
    }
    if (response.status == HttpStatusCode.Created) {
        val result = response.body<ResponseOkLogin>()
        println("${result.accesstoken} et ${result.refreshtoken}")
        return LoginResult.Ok(result)
    } else if (response.status == HttpStatusCode.BadRequest) {
        val result = response.body<ResponseBadRequest>()
        println(result.message[0])
        return LoginResult.Bad(result)
    }else{
        val result=response.body<ResponseErrorMessage>()
        println(result.message)
        return LoginResult.Err(result)
    }
}
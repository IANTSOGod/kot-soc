package com.example.socials.types

sealed class LoginResult {
    data class Ok(val data: ResponseOkLogin): LoginResult()
    data class Bad(val data: ResponseBadRequest): LoginResult()
    data class Err(val data: ResponseErrorMessage): LoginResult()
}
package com.example.socials.types

sealed class SignupResult {
    data class Ok(val data: ResponseOkSignup): SignupResult()
    data class Bad(val data: ResponseBadRequest): SignupResult()
    data class Err(val data: ResponseErrorMessage): SignupResult()
}
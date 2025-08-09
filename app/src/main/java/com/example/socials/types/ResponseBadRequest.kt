package com.example.socials.types

import kotlinx.serialization.Serializable

@Serializable
data class ResponseBadRequest (val message: List<String>,val error:String,val statusCode: Int)
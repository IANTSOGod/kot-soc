package com.example.socials.types

import kotlinx.serialization.Serializable

@Serializable
data class ResponseOkLogin(val accesstoken: String,val refreshtoken:String)
package com.example.socials.types

import kotlinx.serialization.Serializable

@Serializable
data class Usersignup(val username: String, val email: String, val password:String)
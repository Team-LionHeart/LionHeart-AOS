package com.lionheart.data.model.response

data class AuthTokenResponse(
    val accessToken: String,
    val refreshToken: String,
)

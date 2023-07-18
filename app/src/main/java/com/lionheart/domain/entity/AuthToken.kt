package com.lionheart.domain.entity

data class AuthToken(
    val accessToken: String,
    val refreshToken: String?,
)

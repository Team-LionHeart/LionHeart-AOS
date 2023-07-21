package com.lionheart.domain.entity

data class Authentication(
    val accessToken: String,
    val refreshToken: String?,
)
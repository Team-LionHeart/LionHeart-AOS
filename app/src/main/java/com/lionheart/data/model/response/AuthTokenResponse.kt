package com.lionheart.data.model.response

import com.lionheart.domain.entity.AuthToken

data class AuthTokenResponse(
    val accessToken: String,
    val refreshToken: String,
) {
    fun toAuthToken() = AuthToken(accessToken, refreshToken)
}

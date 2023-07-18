package com.lionheart.data.model.request

data class SocialLoginRequest(
    val socialType: String,
    val token: String,
    val fcmToken: String,
)

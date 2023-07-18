package com.lionheart.data.model.request

data class SignUpRequest(
    val socialType: String,
    val token: String,
    val fcmToken: String,
    val pregnantWeeks: Int,
    val babyNickname: String,
)

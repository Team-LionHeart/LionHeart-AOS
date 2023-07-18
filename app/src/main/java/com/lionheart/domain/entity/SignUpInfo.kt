package com.lionheart.domain.entity

data class SignUpInfo(
    val socialType: SocialType,
    val token: String,
    val fcmToken: String,
    val pregnantWeek: Int,
    val babyNickname: String,
)

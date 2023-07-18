package com.lionheart.data.model.response

data class MemberResponse(
    val babyNickname: String,
    val level: String, // TODO : enum
    val notificationStatus: String,
)

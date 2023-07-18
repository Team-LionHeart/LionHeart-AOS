package com.lionheart.data.model.response

data class ChallengeProgressResponse(
    val babyNickname: String,
    val day: Int,
    val level: String, // TODO : enum
    val attendances: List<String>,
)
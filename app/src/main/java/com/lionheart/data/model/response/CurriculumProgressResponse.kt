package com.lionheart.data.model.response

data class CurriculumProgressResponse(
    val week: Int,
    val day: Int,
    val progress: Int,
    val remainingDay: Int,
)
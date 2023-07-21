package com.lionheart.domain.entity

data class CurriculumProgress(
    val week: Long,
    val day: Int,
    val progress: Int,
    val remainingDay: Int,
)

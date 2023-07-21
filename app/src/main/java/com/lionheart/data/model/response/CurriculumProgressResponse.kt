package com.lionheart.data.model.response

import com.lionheart.domain.entity.CurriculumProgress
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CurriculumProgressResponse(
    @SerialName("week")
    val week: Int,
    @SerialName("day")
    val day: Int,
    @SerialName("progress")
    val progress: Int,
    @SerialName("remainingDay")
    val remainingDay: Int,
) {
    fun toCurriculumProgressEntity() = CurriculumProgress(
        week = week.toLong(),
        day = day,
        progress = progress,
        remainingDay = remainingDay,
    )
}

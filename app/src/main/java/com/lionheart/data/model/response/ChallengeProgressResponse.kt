package com.lionheart.data.model.response

import com.lionheart.domain.entity.AttendancesType
import com.lionheart.domain.entity.Challenge
import com.lionheart.domain.entity.ChallengeAttendancesType
import com.lionheart.domain.entity.Level
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ChallengeProgressResponse(
    @SerialName("attendances")
    val attendances: List<String>,
    @SerialName("babyNickname")
    val babyNickname: String,
    @SerialName("day")
    val day: Int,
    @SerialName("level")
    val level: String,
) {
    fun toChallengeEntity() = Challenge(
        attendances = attendances.map { attendance ->
            AttendancesType(attendance, ChallengeAttendancesType.ATTEANDANCES)
        }.toMutableList(),
        babyNickname = babyNickname,
        day = day,
        level = Level.valueOf(level),
    )
}

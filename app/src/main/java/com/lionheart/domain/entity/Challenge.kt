package com.lionheart.domain.entity

data class Challenge(
    val attendances: MutableList<AttendancesType>,
    val babyNickname: String,
    val day: Int,
    val level: String,
) {
    fun asFullList(): List<AttendancesType> = attendances.apply {
        for (no in this.size + 1..20) {
            this.add(AttendancesType("$no", ChallengeAttendancesType.DAY))
        }
    }
}

data class AttendancesType(
    val attendance: String,
    val type: ChallengeAttendancesType,
)

enum class ChallengeAttendancesType(val id: Int) {
    DAY(0), ATTEANDANCES(1),
}

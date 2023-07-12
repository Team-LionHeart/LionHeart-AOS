package com.lionheart.domain.entity

sealed class CourseWeeklyData {
    data class Month(
        val month: Int
    ) : CourseWeeklyData()

    data class Week(
        val week: Int,
        val title: String,
        val image: Int,
        val content: String
    ) : CourseWeeklyData()
}

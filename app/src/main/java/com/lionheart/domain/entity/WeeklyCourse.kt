package com.lionheart.domain.entity

class WeeklyCourse(
    val weekData: WeeklyCourseData
) : Course {
    class WeeklyCourseData(
        val week: Int,
        val title: String,
        val image: String,
        val content: String
    ) : Course.CourseData

    override fun getType() = 1
    override fun getData() = weekData
}

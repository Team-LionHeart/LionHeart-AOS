package com.lionheart.domain.entity

class MonthlyCourse(
    val month: Int
) : Course {
    private val data = MonthlyCourseData(month)

    class MonthlyCourseData(
        val month: Int
    ) : Course.CourseData

    override fun getType() = 0
    override fun getData() = data
}


package com.lionheart.domain.entity

interface Course {
    fun getType(): Int
    fun getData(): CourseData

    interface CourseData

    companion object {
        fun asWeek(weekData: WeeklyCourse.WeeklyCourseData) = WeeklyCourse(weekData)
        fun asMonth(month: Int) = MonthlyCourse(month)
    }
}
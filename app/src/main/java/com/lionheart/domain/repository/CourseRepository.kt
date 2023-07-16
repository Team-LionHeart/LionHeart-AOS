package com.lionheart.domain.repository

import com.lionheart.domain.entity.Course

interface CourseRepository {
    suspend fun getCourseWeekly() : List<Course>
}
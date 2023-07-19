package com.lionheart.presentation.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.data.repository.CourseRepositoryImpl
import com.lionheart.domain.entity.Course
import com.lionheart.domain.repository.CourseRepository
import kotlinx.coroutines.launch

class CourseViewModel : ViewModel() {
    private val _courseList: MutableLiveData<List<Course>> = MutableLiveData<List<Course>>()
    val courseList: LiveData<List<Course>>
        get() = _courseList

    private val courseRepository: CourseRepository by lazy {
        CourseRepositoryImpl()
    }

    fun setData() {
        viewModelScope.launch {
            _courseList.value = courseRepository.getCourseWeekly()
        }
    }

    fun getScrollStartPosition(week: Int): Int {
        if (week == 40) return week + (week / 4) - 5
        return week + (week / 4) - 4
    }
}
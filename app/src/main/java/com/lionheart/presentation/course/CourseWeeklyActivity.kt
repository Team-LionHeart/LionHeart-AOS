package com.lionheart.presentation.course

import androidx.activity.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityCourseWeeklyBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CourseWeeklyActivity :
    BindingActivity<ActivityCourseWeeklyBinding>(R.layout.activity_course_weekly) {
    private val viewModel by viewModels<CourseWeeklyViewModel>()
}

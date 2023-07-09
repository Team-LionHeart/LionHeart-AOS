package com.lionheart.presentation.course

import androidx.activity.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityWeeklyCourseBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeeklyCourseActivity :
    BindingActivity<ActivityWeeklyCourseBinding>(R.layout.activity_weekly_course) {
    private val viewModel by viewModels<WeeklyCourseViewModel>()
}

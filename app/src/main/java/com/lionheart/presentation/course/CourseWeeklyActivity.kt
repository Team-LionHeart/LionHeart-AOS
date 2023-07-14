package com.lionheart.presentation.course

import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityCourseWeeklyBinding
import com.lionheart.domain.entity.CourseWeek
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CourseWeeklyActivity :
    BindingActivity<ActivityCourseWeeklyBinding>(R.layout.activity_course_weekly) {
    private val viewModel by viewModels<CourseWeeklyViewModel>()
    private var _courseWeeklyTitleAdapter: CourseWeeklyTitleAdapter? = null
    private val courseWeeklyTitleAdapter
        get() = requireNotNull(_courseWeeklyTitleAdapter) { Timber.e("adapter not initialized") }
    private var _courseWeeklyAdapter: CourseWeeklyAdapter? = null
    private val courseWeeklyAdapter
        get() = requireNotNull(_courseWeeklyAdapter) { Timber.e("adapter not initialized") }

    override fun constructLayout() {
        // databinding
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@CourseWeeklyActivity
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        _courseWeeklyTitleAdapter = CourseWeeklyTitleAdapter(viewModel.tempHeader)
        _courseWeeklyAdapter = CourseWeeklyAdapter(viewModel.courseWeeklyList)
        with(binding.rvCourseWeekly) {
            adapter = ConcatAdapter(courseWeeklyTitleAdapter, courseWeeklyAdapter)
        }
    }
}

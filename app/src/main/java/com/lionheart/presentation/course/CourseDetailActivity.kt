package com.lionheart.presentation.course

import androidx.activity.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityCourseWeeklyBinding
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class CourseDetailActivity :
    BindingActivity<ActivityCourseWeeklyBinding>(R.layout.activity_course_weekly) {
    private val viewModel by viewModels<CourseDetailViewModel>()
    private var _courseWeeklyTitleAdapter: CourseDetailTitleAdapter? = null
    private val courseWeeklyTitleAdapter
        get() = requireNotNull(_courseWeeklyTitleAdapter) { Timber.e("adapter not initialized") }
    private var _courseWeeklyAdapter: CourseDetailAdapter? = null
    private val courseWeeklyAdapter
        get() = requireNotNull(_courseWeeklyAdapter) { Timber.e("adapter not initialized") }

    override fun constructLayout() {
        // databinding
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@CourseDetailActivity
        }
        initRecyclerView()
    }

    private fun initRecyclerView() {
        _courseWeeklyTitleAdapter = CourseDetailTitleAdapter(viewModel.tempHeader)
        _courseWeeklyAdapter = CourseDetailAdapter(viewModel.courseWeeklyList)
        with(binding.rvCourseWeekly) {
            adapter = ConcatAdapter(courseWeeklyTitleAdapter, courseWeeklyAdapter)
        }
    }
}

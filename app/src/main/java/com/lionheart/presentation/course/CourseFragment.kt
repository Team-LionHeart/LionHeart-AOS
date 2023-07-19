package com.lionheart.presentation.course

import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentCourseBinding
import timber.log.Timber


class CourseFragment : BindingFragment<FragmentCourseBinding>(R.layout.fragment_course) {
    private val viewModel by viewModels<CourseViewModel>()
    private var _courseAdapter: CourseAdapter? = null
    private val courseAdapter
        get() = requireNotNull(_courseAdapter) { Timber.e("adapter not initialized") }

    override fun constructLayout() {
        // databinding
        with(binding) {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        initRecyclerView()
        viewModel.setData()
        binding.lottieCourseProgress.setAnimation(R.raw.progressbar_7m)
    }

    private fun initRecyclerView() {
        viewModel.courseList.observe(this@CourseFragment) {
            _courseAdapter = CourseAdapter(it)

            with(binding.rvCourseContent) {
                adapter = courseAdapter
                layoutManager = LinearLayoutManager(context)
                (layoutManager as LinearLayoutManager).scrollToPosition(viewModel.getScrollStartPosition(10))
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _courseAdapter = null
    }
}
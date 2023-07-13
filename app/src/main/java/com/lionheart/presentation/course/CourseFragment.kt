package com.lionheart.presentation.course

import android.transition.AutoTransition
import android.transition.TransitionManager
import android.view.View
import androidx.annotation.NonNull
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
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
    }

    private fun initRecyclerView() {
        _courseAdapter = CourseAdapter(viewModel.courseList)
        with(binding.rvCourseContent) {
            adapter = courseAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _courseAdapter = null
    }
}
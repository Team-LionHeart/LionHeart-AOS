package com.lionheart.presentation.course

import android.content.Intent
import androidx.fragment.app.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.FragmentCourseBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class CourseFragment : BindingFragment<FragmentCourseBinding>(R.layout.fragment_course) {
    private val viewModel by viewModels<CourseViewModel>()
    private var _courseAdapter: CourseAdapter? = null
    private val courseAdapter
        get() = requireNotNull(_courseAdapter) { Timber.e("adapter not initialized") }
    private var week: Int? = null

    override fun constructLayout() {
        // databinding
        with(binding) {
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
        }
        viewModel.getCourseProgress()
        getCourseProgressState()
        initRecyclerView()
        viewModel.setData()
    }

    private fun initRecyclerView() {
        viewModel.courseList.observe(this@CourseFragment) {
            _courseAdapter = CourseAdapter(it) { week, image -> goToDetail(week.toInt(), image) }

            with(binding.rvCourseContent) {
                adapter = courseAdapter
                layoutManager = LinearLayoutManager(context)
                week?.let { week ->
                    viewModel.getScrollStartPosition(
                        week,
                    )
                }?.let { it ->
                    (layoutManager as LinearLayoutManager).scrollToPosition(
                        it,
                    )
                }
            }
        }
    }

    private fun goToDetail(week: Int, image: String) {
        Intent(activity, CourseDetailActivity::class.java).apply {
            putExtra(WEEK, week)
            putExtra("imageUrl", image)
        }.run(::startActivity)
    }

    private fun getCourseProgressState() {
        viewModel.courseProgressState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getCourseProgressState").d(event.code.toString())
                }

                is Success -> {
                    val response = event.data
                    binding.data = response
                    week = response.week.toInt() + 10
                    when (response.week / 4 + 1) {
                        2.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_2m)
                        }

                        3.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_3m)
                        }

                        4.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_4m)
                        }

                        5.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_5m)
                        }

                        6.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_6m)
                        }

                        7.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_7m)
                        }

                        8.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_8m)
                        }

                        9.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_9m)
                        }

                        10.toLong() -> {
                            binding.lottieCourseProgress.setAnimation(R.raw.progressbar_10m)
                        }
                    }
                }
            }
        }.launchIn(lifecycleScope)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _courseAdapter = null
    }

    companion object {
        const val WEEK = "week"
    }
}

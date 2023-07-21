package com.lionheart.presentation.course

import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.intent.getParcelable
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.ActivityCourseWeeklyBinding
import com.lionheart.presentation.course.CourseFragment.Companion.WEEK
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
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
        getWeeklyArticle()
        Timber.d("${intent.getLongExtra("week", 0)}, ${intent.getStringExtra("imageUrl")}")
        // databinding
        with(binding) {
            vm = viewModel
            lifecycleOwner = this@CourseDetailActivity
        }
        initRecyclerView()
    }

    override fun addListeners() {
        binding.btnCourseWeeklyBack.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun initRecyclerView() {
        _courseWeeklyTitleAdapter = CourseDetailTitleAdapter(viewModel.tempHeader)
        _courseWeeklyAdapter = CourseDetailAdapter { articleId, switching ->
            viewModel.switchBookmark(
                articleId,
                switching,
            )
        }
        getWeeklyArticleState()

        with(binding.rvCourseWeekly) {
            adapter = ConcatAdapter(courseWeeklyTitleAdapter, courseWeeklyAdapter)
        }
    }

    private fun getWeeklyArticle() {
        val week = intent.getLongExtra(WEEK, 2)
        viewModel.getCourseArticle(week)
    }

    private fun getWeeklyArticleState() {
        viewModel.getCourseArticleState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getWeeklyArticleError").d(event.code.toString())
                }

                is Success -> {
                    courseWeeklyAdapter.submitList(event.data)
                }
            }
        }.launchIn(lifecycleScope)
    }
}

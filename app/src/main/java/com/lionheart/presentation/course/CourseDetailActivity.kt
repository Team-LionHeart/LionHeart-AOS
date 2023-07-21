package com.lionheart.presentation.course

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.ActivityCourseDetailBinding
import com.lionheart.domain.entity.CourseWeek
import com.lionheart.presentation.article.ArticleActivity
import com.lionheart.presentation.course.CourseFragment.Companion.WEEK
import com.lionheart.presentation.search.category.SearchDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class CourseDetailActivity :
    BindingActivity<ActivityCourseDetailBinding>(R.layout.activity_course_detail) {
    private val viewModel by viewModels<CourseDetailViewModel>()
    private var _courseWeeklyTitleAdapter: CourseDetailTitleAdapter? = null
    private val courseWeeklyTitleAdapter
        get() = requireNotNull(_courseWeeklyTitleAdapter) { Timber.e("adapter not initialized") }
    private var _courseWeeklyAdapter: CourseDetailAdapter? = null
    private val courseWeeklyAdapter
        get() = requireNotNull(_courseWeeklyAdapter) { Timber.e("adapter not initialized") }

    override fun constructLayout() {
        getWeeklyArticle()
        Timber.tag("course detail")
            .d("${intent.getLongExtra("week", 0)}, ${intent.getStringExtra("imageUrl")}")

        with(binding) {
            // databinding
            vm = viewModel
            lifecycleOwner = this@CourseDetailActivity

            // ui
            tvCourseWeeklyTitle.text = resources.getString(
                R.string.course_weekly_title,
                intent.getLongExtra("week", 0).toString()
            )
        }
        initRecyclerView()
    }

    override fun addListeners() {
        binding.btnCourseWeeklyBack.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun initRecyclerView() {
        _courseWeeklyTitleAdapter = CourseDetailTitleAdapter(
            CourseWeek(
                intent.getLongExtra("week", 0).toInt(),
                intent.getStringExtra("imageUrl")!!
            )
        )
        _courseWeeklyAdapter = CourseDetailAdapter(
            { articleId, switching ->
                viewModel.switchBookmark(
                    articleId,
                    switching,
                )
            },
            { articleId ->
            },
                intentToArticleDetail(articleId)
        )
        getWeeklyArticleState()

        with(binding.rvCourseWeekly) {
            adapter = ConcatAdapter(courseWeeklyTitleAdapter, courseWeeklyAdapter)
        }
    }

    private fun intentToArticleDetail(articleId: Int) {
        Intent(this, ArticleActivity::class.java).apply {
            putExtra(SearchDetailActivity.ARTICLE_ID, articleId)
        }.run(::startActivity)
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

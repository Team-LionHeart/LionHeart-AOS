package com.lionheart.presentation.bookmark

import android.content.Intent
import android.util.Log
import android.view.View
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.ActivityBookmarkBinding
import com.lionheart.domain.entity.BookmarkArticle
import com.lionheart.presentation.article.ArticleActivity
import com.lionheart.presentation.search.category.SearchDetailActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class BookMarkActivity : BindingActivity<ActivityBookmarkBinding>(R.layout.activity_bookmark) {
    private var bookmarkTitleAdapter: BookmarkTitleAdapter? = null
    private var bookmarkArticleAdapter: BookmarkArticleAdapter? = null
    private val viewModel by viewModels<BookmarkViewModel>()

    override fun constructLayout() {
        viewModel.getBookmarkArticle()
        initAdapter()
        getBookmarkArticleState()
    }

    override fun addListeners() {
        onClickBackButton()
    }

    private fun initAdapter() {
        bookmarkTitleAdapter = BookmarkTitleAdapter()
        bookmarkArticleAdapter = BookmarkArticleAdapter(
            { articleId, switching ->
                viewModel.switchBookmark(articleId, switching)
            },
            { articleId, isMarked ->
                intentToArticleDetail(articleId, isMarked)
            },
        )

        binding.rvBookmarkArticle.adapter =
            ConcatAdapter(bookmarkTitleAdapter, bookmarkArticleAdapter)
    }

    private fun intentToArticleDetail(articleId: Int, isMarked: Boolean) {
        val intent = Intent(this, ArticleActivity::class.java).apply {
            putExtra(SearchDetailActivity.ARTICLE_ID, articleId)
            putExtra(SearchDetailActivity.IS_MARKED, isMarked)
        }
        getResultBookmark.launch(intent)
    }

    private val getResultBookmark = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            Log.d("뭐가 문제냐ㅁㄴ옿ㅁ;ㅓㄴㅇ롬ㄴ올", "ㅁㄴ아ㅓ호만오리")
            viewModel.getBookmarkArticle()
        }
    }

    private fun onClickBackButton() {
        binding.ivBookmarkBackButton.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun getBookmarkArticleState() {
        viewModel.bookmarkArticleState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getBookmarkArticleState").d(event.code.toString())
                }

                is Success -> {
                    bookmarkTitleAdapter?.submitList(listOf(event.data.babyNickname))
                    bookmarkArticleAdapter?.submitList(event.data.articleSummaries)
                    checkBookmarkListEmpty(event.data.articleSummaries)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun checkBookmarkListEmpty(articleSummaries: List<BookmarkArticle.ArticleSummary>) {
        if (articleSummaries.isEmpty()) {
            binding.tvBookmarkEmptyBookmarkList.visibility = View.VISIBLE
        }
    }
}

package com.lionheart.presentation.search.category

import android.content.Intent
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ConcatAdapter
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.intent.getParcelable
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.ActivitySearchDetailBinding
import com.lionheart.domain.entity.SearchCategory
import com.lionheart.presentation.article.ArticleActivity
import com.lionheart.presentation.search.SearchFragment.Companion.SEARCH_CATEGORY
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class SearchDetailActivity :
    BindingActivity<ActivitySearchDetailBinding>(R.layout.activity_search_detail) {
    private val viewModel by viewModels<SearchDetailViewModel>()
    private var searchDetailAdapter: SearchDetailAdapter? = null
    private var searchDetailTitleAdapter: SearchDetailTitleAdapter? = null

    override fun constructLayout() {
        getCategoryArticle()
        initAdapter()
    }

    override fun addListeners() {
        onClickBackButton()
    }

    private fun initAdapter() {
        val searchCategory = intent.getParcelable(SEARCH_CATEGORY, SearchCategory::class.java)
        searchDetailAdapter = SearchDetailAdapter(
            { article, articleId, switching ->
                viewModel.switchBookmark(
                    articleId,
                    switching,
                )
            },
            { articleId, isMarked ->
                intentToArticleDetail(articleId, isMarked)
            },
        )
        searchCategory?.let {
            searchDetailTitleAdapter = SearchDetailTitleAdapter(it)
        }
        submitSearchDetailArticle()

        binding.rvSearchDetailArticle.adapter =
            ConcatAdapter(searchDetailTitleAdapter, searchDetailAdapter)
    }

    private fun getCategoryArticle() {
        val searchCategory = intent.getParcelable(SEARCH_CATEGORY, SearchCategory::class.java)
        searchCategory?.serverName?.let { viewModel.getCategoryArticle(it) }
    }

    private fun submitSearchDetailArticle() {
        viewModel.getCategoryArticleState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getCategoryArticleState").d(event.code.toString())
                }

                is Success -> {
                    searchDetailAdapter?.submitList(event.data)
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun intentToArticleDetail(articleId: Int, isMarked: Boolean) {
        val intent = Intent(this, ArticleActivity::class.java).apply {
            putExtra(ARTICLE_ID, articleId)
            putExtra(IS_MARKED, isMarked)
        }
        getResultBookmark.launch(intent)
    }

    private fun onClickBackButton() {
        binding.ivSearchDetailBackButton.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private val getResultBookmark = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
    ) { result: ActivityResult ->
        if (result.resultCode == RESULT_OK) {
            getCategoryArticle()
        }
    }

    companion object {
        const val ARTICLE_ID = "articleId"
        const val IS_MARKED = "is_marked"
    }
}

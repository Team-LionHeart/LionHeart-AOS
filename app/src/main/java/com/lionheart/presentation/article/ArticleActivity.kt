package com.lionheart.presentation.article

import android.view.View
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.databinding.ActivityArticleBinding
import com.lionheart.presentation.search.category.SearchDetailActivity.Companion.ARTICLE_ID
import com.lionheart.presentation.search.category.SearchDetailActivity.Companion.IS_MARKED
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class ArticleActivity : BindingActivity<ActivityArticleBinding>(R.layout.activity_article) {
    private lateinit var articleAdaptor: ArticleAdaptor
    private val viewModel by viewModels<ArticleViewModel>()
    override fun constructLayout() {
        binding.vm = viewModel
        setAdaptor()
        getArticleComponents()
        getArticleComponentsState()
    }

    override fun addListeners() {
        listenScroll()
        onClickBackButton()
    }

    private fun setAdaptor() {
        articleAdaptor = ArticleAdaptor()
        getArticleComponentsState()
        binding.rvArticleMain.adapter = articleAdaptor
    }

    private fun getArticleComponents() {
        val articleId = intent.getIntExtra(ARTICLE_ID, 1)
        viewModel.getArticleDetail(articleId)
    }

    private fun getArticleComponentsState() {
        viewModel.getArticleDetailState.flowWithLifecycle(lifecycle).onEach { event ->
            when (event) {
                is Failure -> {
                    Timber.tag("getArticleComponentsState").d(event.code.toString())
                }

                is Success -> {
                    val articleId = intent.getIntExtra(ARTICLE_ID, 1)
                    val data = event.data
                    viewModel.setBookmark(data.isMarked)
                    binding.data = data
                    articleAdaptor.submitList(data.contents)
                    viewModel.bookmarked.value?.let { onTouchBookmark(articleId.toLong(), it.not()) }
                }
            }
        }.launchIn(lifecycleScope)
    }

    private fun onClickBackButton() {
        binding.ivArticleTopX.setOnClickListener {
            if (!isFinishing) finish()
        }
    }

    private fun listenScroll() {
        binding.layoutArticleScroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val maxScroll =
                binding.layoutArticleScroll.getChildAt(0).height - binding.layoutArticleScroll.height
            binding.progressArticleTop.progress = ((scrollY.toFloat() / maxScroll) * 100).toInt()

            if (scrollY <= oldScrollY) { // on down Scroll
                binding.fbtnArticleGoTop.visibility = View.VISIBLE
            } else { // on up Scroll
                binding.fbtnArticleGoTop.visibility = View.GONE
            }

            if (scrollY == 0) {
                binding.fbtnArticleGoTop.visibility = View.GONE
            }
        }

        binding.fbtnArticleGoTop.setOnClickListener {
            binding.layoutArticleScroll.scrollY = 0
            binding.fbtnArticleGoTop.visibility = View.GONE
        }
    }

    private fun onTouchBookmark(articleId: Long, isMarked: Boolean) {
        binding.ivArticleBookmark.setOnClickListener {
            viewModel.swtich()

            viewModel.switchBookmark(articleId, isMarked)
            setResult(RESULT_OK)
        }
    }
}

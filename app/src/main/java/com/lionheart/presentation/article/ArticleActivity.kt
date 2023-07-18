package com.lionheart.presentation.article

import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityArticleBinding

class ArticleActivity : BindingActivity<ActivityArticleBinding>(R.layout.activity_article) {
    private lateinit var adaptor: ArticleAdaptor
    override fun constructLayout() {
        setAdaptor()
        setProgressBar()
    }

    override fun addListeners() {
    }

    private fun setAdaptor() {
        adaptor = ArticleAdaptor()
        binding.rvArticleMain.adapter = adaptor
        adaptor.submitList(getArticleComponents())
    }

    private fun getArticleComponents() = ArticleMocker.mockChapter1()

    private fun setProgressBar() {
        binding.layoutArticleScroll.setOnScrollChangeListener { v, scrollX, scrollY, oldScrollX, oldScrollY ->
            val maxScroll =
                binding.layoutArticleScroll.getChildAt(0).height - binding.layoutArticleScroll.height
            binding.progressArticleTop.progress = ((scrollY.toFloat() / maxScroll) * 100).toInt()
        }
    }
}
package com.lionheart.presentation.article

import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityArticleBinding

class ArticleActivity : BindingActivity<ActivityArticleBinding>(R.layout.activity_article) {
    private lateinit var adaptor: ArticleAdaptor
    override fun constructLayout() {
        setAdaptor()
    }

    private fun setAdaptor() {
        adaptor = ArticleAdaptor()
        binding.rvArticleMain.adapter = adaptor
        adaptor.submitList(getArticleComponents())
    }

    private fun getArticleComponents() = ArticleMocker.mockChapter1()
}
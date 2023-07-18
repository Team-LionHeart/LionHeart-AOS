package com.lionheart.presentation.article

import android.view.View
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityArticleBinding

class ArticleActivity : BindingActivity<ActivityArticleBinding>(R.layout.activity_article) {
    private lateinit var adaptor: ArticleAdaptor
    override fun constructLayout() {
        setAdaptor()
    }

    override fun addListeners() {
        listenScroll()
    }

    private fun setAdaptor() {
        adaptor = ArticleAdaptor()
        binding.rvArticleMain.adapter = adaptor
        adaptor.submitList(getArticleComponents())
    }

    private fun getArticleComponents() = ArticleMocker.mockChapter1()

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
}
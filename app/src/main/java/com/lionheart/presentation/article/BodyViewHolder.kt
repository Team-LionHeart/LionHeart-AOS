package com.lionheart.presentation.article

import android.view.View
import com.lionheart.databinding.ItemArticleBodyBinding
import com.lionheart.domain.entity.ArticleComponent

class BodyViewHolder(private val componentBinding: ItemArticleBodyBinding) :
    ArticleViewHolder(componentBinding.root) {
    override fun onBind(articleComponent: ArticleComponent) {
        with(componentBinding) {
            component = articleComponent

            // body 의 caption 이 없는 경우 -> caption visibility 를 없앤다.
            if (articleComponent.caption.isNullOrBlank()) {
                tvArticleBodyCaption.visibility = View.GONE
            }

            // body 의 caption 이 있는 경우 -> caption visibility 는 살리고, 기존 bottom padding 을 제거한다.
            else {
                layoutArticleBody.setPadding(0, 0, 0, 0)
                tvArticleBodyCaption.visibility = View.VISIBLE
            }
        }
    }
}
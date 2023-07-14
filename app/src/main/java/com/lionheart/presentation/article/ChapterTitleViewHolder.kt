package com.lionheart.presentation.article

import com.lionheart.databinding.ItemArticleChaptorTitleBinding
import com.lionheart.domain.entity.ArticleComponent

class ChapterTitleViewHolder(private val componentBinding: ItemArticleChaptorTitleBinding) :
    ArticleViewHolder(componentBinding.root) {

    override fun onBind(articleComponent: ArticleComponent) {
        with(componentBinding) {
            component = articleComponent
        }
    }
}
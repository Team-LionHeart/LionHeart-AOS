package com.lionheart.presentation.article

import com.lionheart.databinding.ItemArticleGeneralTitleBinding
import com.lionheart.domain.entity.ArticleComponent

class GeneralTitleViewHolder(private val componentBinding: ItemArticleGeneralTitleBinding) :
    ArticleViewHolder(componentBinding.root) {
    override fun onBind(articleComponent: ArticleComponent) {
        with(componentBinding) {
            component = articleComponent
        }
    }
}
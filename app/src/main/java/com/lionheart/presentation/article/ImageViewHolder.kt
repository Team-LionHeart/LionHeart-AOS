package com.lionheart.presentation.article

import coil.load
import com.lionheart.R
import com.lionheart.databinding.ItemArticleImageBinding
import com.lionheart.domain.entity.ArticleComponent

class ImageViewHolder(private val componentBinding: ItemArticleImageBinding) :
    ArticleViewHolder(componentBinding.root) {
    override fun onBind(articleComponent: ArticleComponent) {
        with(componentBinding) {
            component = articleComponent
        }
    }
}
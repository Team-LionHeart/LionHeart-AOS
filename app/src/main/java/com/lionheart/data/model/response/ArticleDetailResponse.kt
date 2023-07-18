package com.lionheart.data.model.response

import com.lionheart.domain.entity.ArticleComponentType

data class ArticleDetailResponse(
    val title: String,
    val author: String,
    val mainImageUrl: String,
    val mainImageCaption: String,
    val isMarked: Boolean,
    val contents: List<ArticleComponentResponse>
) {
    data class ArticleComponentResponse(
        val content: String,
        val caption: String,
        val type: ArticleComponentType
    )
}

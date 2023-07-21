package com.lionheart.domain.entity

data class ArticleDetail(
    val title: String,
    val author: String,
    val mainImageUrl: String,
    val mainImageCaption: String,
    var isMarked: Boolean,
    val contents: List<ArticleComponent>
)
package com.lionheart.domain.entity

data class Article(
    val articleId: Long,
    val title: String,
    val mainImageUrl: String,
    val firstBodyContent: String?,
    val requiredTime: Long?,
    var isMarked: Boolean,
    val tags: List<String>,
)
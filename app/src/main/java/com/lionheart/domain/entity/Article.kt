package com.lionheart.domain.entity

data class Article(
    val articleId: Long,
    val title: String,
    val mainImageUrl: String,
    val firstBodyContent: String,
    val requiredTime: Long,
    val isMarked: Boolean,
    val tags: List<String>,
)
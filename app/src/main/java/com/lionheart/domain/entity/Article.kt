package com.lionheart.domain.entity

data class Article(
    val title: String,
    val mainImageUrl: String,
    val firstBodyContent: String,
    val requiredTime: Int,
    val isMarked: Boolean,
    val tags: List<String>,
)
package com.lionheart.data.model.response

data class WeeklyArticleResponse(
    val articleId: Long,
    val title: String,
    val mainImageUrl: String,
    val firstBodyContent: String,
    val requiredTime: Long,
    val isMarked: Boolean,
    val tags: List<String>
)
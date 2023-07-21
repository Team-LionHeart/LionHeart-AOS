package com.lionheart.domain.entity

import kotlinx.serialization.SerialName

data class BookmarkArticle(
    val articleSummaries: List<ArticleSummary>,
    val babyNickname: String,
){
    data class ArticleSummary(
        val articleId: Long,
        var isMarked: Boolean,
        val mainImageUrl: String,
        val tags: List<String>,
        val title: String,
    )
}

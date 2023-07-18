package com.lionheart.domain.entity

data class BookmarkArticle(
    val articleSummaries: List<ArticleSummary>,
    val babyNickname: String,
){
    data class ArticleSummary(
        val isMarked: Boolean,
        val mainImageUrl: String,
        val tags: List<String>,
        val title: String,
    )
}

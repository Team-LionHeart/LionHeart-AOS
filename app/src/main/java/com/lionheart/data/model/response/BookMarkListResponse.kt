package com.lionheart.data.model.response

data class BookMarkListResponse(
    val babyNickname: String,
    val articleSummaries: List<ArticleSummaryResponse>,
) {
    data class ArticleSummaryResponse(
        val articleId: Long,
        val title: String,
        val mainImageUrl: String,
        val isMarked: Boolean,
        val tags: List<String>
    )
}

package com.lionheart.data.model.response

data class ArticleListResponse(
    val categoryArticles: List<ArticleResponse>,
) {
    data class ArticleResponse(
        val articleId: Long,
        val title: String,
        val mainImageUrl: String,
        val firstBodyContent: String,
        val requiredTime: Long,
        val isMarked: Boolean,
        val tags: List<String>
    )
}

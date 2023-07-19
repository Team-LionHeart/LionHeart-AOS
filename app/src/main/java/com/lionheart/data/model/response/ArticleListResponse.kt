package com.lionheart.data.model.response

import com.lionheart.domain.entity.Article

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
    ) {
        fun toArticleEntity() = Article(
            title = title,
            mainImageUrl = mainImageUrl,
            firstBodyContent = firstBodyContent,
            requiredTime = requiredTime,
            isMarked = isMarked,
            tags = tags,
        )
    }
}

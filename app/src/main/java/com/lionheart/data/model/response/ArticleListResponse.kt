package com.lionheart.data.model.response

import com.lionheart.domain.entity.Article
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleListResponse(
    @SerialName("articleSummaries")
    val articleSummaries: List<ArticleResponse>,
) {
    @Serializable
    data class ArticleResponse(
        @SerialName("articleId")
        val articleId: Long,
        @SerialName("title")
        val title: String,
        @SerialName("mainImageUrl")
        val mainImageUrl: String,
        @SerialName("firstBodyContent")
        val firstBodyContent: String,
        @SerialName("requiredTime")
        val requiredTime: Long,
        @SerialName("isMarked")
        val isMarked: Boolean,
        @SerialName("tags")
        val tags: List<String>,
    ) {
        fun toArticleEntity() = Article(
            articleId = articleId,
            title = title,
            mainImageUrl = mainImageUrl,
            firstBodyContent = firstBodyContent,
            requiredTime = requiredTime,
            isMarked = isMarked,
            tags = tags,
        )
    }
}

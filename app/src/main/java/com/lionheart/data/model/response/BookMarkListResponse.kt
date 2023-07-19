package com.lionheart.data.model.response

import com.lionheart.domain.entity.BookmarkArticle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookMarkListResponse(
    @SerialName("babyNickname")
    val babyNickname: String,
    @SerialName("articleSummaries")
    val articleSummaries: List<ArticleSummaryResponse>,
) {
    @Serializable
    data class ArticleSummaryResponse(
        @SerialName("articleId")
        val articleId: Long,
        @SerialName("title")
        val title: String,
        @SerialName("mainImageUrl")
        val mainImageUrl: String,
        @SerialName("isMarked")
        val isMarked: Boolean,
        @SerialName("tags")
        val tags: List<String>,
    )

    fun toBookmarkArticleEntity() = BookmarkArticle(
        babyNickname = babyNickname,
        articleSummaries = articleSummaries.map { article ->
            BookmarkArticle.ArticleSummary(
                articleId = article.articleId,
                isMarked = article.isMarked,
                mainImageUrl = article.mainImageUrl,
                tags = article.tags,
                title = article.title,
            )
        },
    )
}

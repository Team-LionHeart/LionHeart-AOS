package com.lionheart.data.model.response

import com.lionheart.domain.entity.BookmarkArticle
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookmarkArticleDto(
    @SerialName("articleSummaries")
    val articleSummaries: List<ArticleSummary>,
    @SerialName("babyNickname")
    val babyNickname: String,
) {
    @Serializable
    data class ArticleSummary(
        @SerialName("firstBodyContent")
        val firstBodyContent: String,
        @SerialName("isMarked")
        val isMarked: Boolean,
        @SerialName("mainImageUrl")
        val mainImageUrl: String,
        @SerialName("requiredTime")
        val requiredTime: Int,
        @SerialName("tags")
        val tags: List<String>,
        @SerialName("title")
        val title: String,
    )

    fun toBookMarkArticle() = BookmarkArticle(
        articleSummaries = articleSummaries.map { articleSummary ->
            BookmarkArticle.ArticleSummary(
                isMarked = articleSummary.isMarked,
                mainImageUrl = articleSummary.mainImageUrl,
                tags = articleSummary.tags,
                title = articleSummary.title,
            )
        },
        babyNickname = babyNickname,
    )
}

package com.lionheart.data.model.response

import com.lionheart.domain.entity.ArticleComponent
import com.lionheart.domain.entity.ArticleComponentType
import com.lionheart.domain.entity.ArticleDetail
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ArticleDetailResponse(
    @SerialName("title")
    val title: String,
    @SerialName("author")
    val author: String,
    @SerialName("mainImageUrl")
    val mainImageUrl: String,
    @SerialName("mainImageCaption")
    val mainImageCaption: String,
    @SerialName("isMarked")
    val isMarked: Boolean,
    @SerialName("contents")
    val contents: List<ArticleComponentResponse>,
) {
    @Serializable
    data class ArticleComponentResponse(
        @SerialName("content")
        val content: String,
        @SerialName("caption")
        val caption: String?,
        @SerialName("type")
        val type: ArticleComponentType,
    )

    fun toArticleDetailEntity() = ArticleDetail(
        title = title,
        author = author,
        mainImageUrl = mainImageUrl,
        mainImageCaption = mainImageCaption,
        isMarked = isMarked,
        contents = contents.map { articleComponent ->
            ArticleComponent(
                content = articleComponent.content,
                caption = articleComponent.caption,
                type = articleComponent.type.id,
            )
        },
    )
}

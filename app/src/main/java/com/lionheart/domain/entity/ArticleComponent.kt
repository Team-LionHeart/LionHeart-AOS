package com.lionheart.domain.entity

data class ArticleComponent(
    val type: ArticleComponentType,
    val content: String,
    val caption: String
)

enum class ArticleComponentType {
    EDITOR_NOTE,
    CHAPTER_TITLE,
    BODY,
    GENERAL_TITLE,
    IMAGE
}

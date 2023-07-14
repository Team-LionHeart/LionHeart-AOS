package com.lionheart.domain.entity

data class ArticleComponent(
    val type: Int,
    val content: String,
    val caption: String? = null
)

enum class ArticleComponentType(val id: Int) {
    EDITOR_NOTE(0),
    CHAPTER_TITLE(1),
    BODY(2),
    GENERAL_TITLE(3),
    IMAGE(4)
    ;
}

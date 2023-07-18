package com.lionheart.domain.entity

data class TodayArticle(
    val articleId: Long,
    val bodyNickname: String,
    val title: String,
    val mainImageUrl: String,
    val editorNoteContent: String,
    val week: Int,
    val day: Int,
)

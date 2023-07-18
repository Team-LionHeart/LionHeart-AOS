package com.lionheart.data.model.response

data class TodayArticleResponse(
    val articleId: Long,
    val babyNickname: String,
    val title: String,
    val mainImageUrl: String,
    val editorNoteContent: String,
    val week: Int,
    val day: Int,
)
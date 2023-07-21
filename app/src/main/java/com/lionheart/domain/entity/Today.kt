package com.lionheart.domain.entity

data class Today(
    val articleId: Long,
    val babyNickname: String,
    val title: String,
    val mainImageUrl: String,
    val editorNoteContent: String,
    val week: Int,
    val day: Int,
)

package com.lionheart.data.model.request

data class BookMarkRequest(
    val articleId: Long,
    val bookmarkStatus: Boolean,
)

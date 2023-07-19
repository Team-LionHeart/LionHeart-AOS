package com.lionheart.data.model.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class BookMarkRequest(
    @SerialName("articleId")
    val articleId: Long,
    @SerialName("bookmarkStatus")
    val bookmarkStatus: Boolean,
)

package com.lionheart.data.model.response

import com.lionheart.domain.entity.Today
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TodayArticleResponse(
    @SerialName("articleId")
    val articleId: Long,
    @SerialName("babyNickname")
    val babyNickname: String,
    @SerialName("title")
    val title: String,
    @SerialName("mainImageUrl")
    val mainImageUrl: String,
    @SerialName("editorNoteContent")
    val editorNoteContent: String,
    @SerialName("week")
    val week: Int,
    @SerialName("day")
    val day: Int,
) {
    fun toTodayEntity() = Today(
        articleId = articleId,
        babyNickname = babyNickname,
        title = title,
        mainImageUrl = mainImageUrl,
        editorNoteContent = editorNoteContent,
        week = week,
        day = day,
    )
}

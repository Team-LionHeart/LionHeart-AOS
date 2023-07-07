package com.lionheart.data.model.response

import com.lionheart.domain.entity.Lion
import kotlinx.serialization.Serializable

@Serializable
data class LionResponse(
    val id: Int,
    val name: String,
) {
    fun toLion() = Lion(
        id = id,
        name = name
    )
}

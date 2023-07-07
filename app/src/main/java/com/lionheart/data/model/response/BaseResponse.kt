package com.lionheart.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<RESULT>(
    val status: Int,
    val success: Boolean,
    val message: String?,
    val data: RESULT?
)
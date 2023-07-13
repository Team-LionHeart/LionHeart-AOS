package com.lionheart.data.model.response

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<RESULT>(
    val code: String?,
    val message: String?,
    val data: RESULT?
)
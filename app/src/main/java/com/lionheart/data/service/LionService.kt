package com.lionheart.data.service

import com.lionheart.data.model.request.LionRequest
import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.LionResponse
import retrofit2.http.Body
import retrofit2.http.GET

interface LionService {
    @GET("/api/lionheart")
    suspend fun getList(
        @Body request: LionRequest
    ): BaseResponse<LionResponse>
}
package com.lionheart.data.datasource

import com.lionheart.data.model.request.LionRequest
import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.LionResponse
import com.lionheart.data.service.LionService
import javax.inject.Inject

class LionDataSource @Inject constructor(
    private val lionService: LionService
) {
    suspend fun getArticleList(week: Int): BaseResponse<LionResponse> =
        lionService.getList(
            LionRequest(id = week)
        )
}
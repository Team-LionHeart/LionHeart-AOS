package com.lionheart.data.service

import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.CurriculumProgressResponse
import retrofit2.http.GET

interface CurriculumService {
    @GET("/api/v1/curriculum/progress")
    suspend fun getCurriculumProgress(): BaseResponse<CurriculumProgressResponse>
}
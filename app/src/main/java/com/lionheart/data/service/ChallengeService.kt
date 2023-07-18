package com.lionheart.data.service

import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.ChallengeProgressResponse
import retrofit2.http.GET

interface ChallengeService {
    @GET("/api/v1/challenge/progress")
    suspend fun getChallengeProgress(): BaseResponse<ChallengeProgressResponse>
}
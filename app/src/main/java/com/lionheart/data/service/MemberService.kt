package com.lionheart.data.service

import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.MemberResponse
import retrofit2.http.DELETE
import retrofit2.http.GET

interface MemberService {
    @DELETE("/api/v1/member")
    suspend fun deleteMember(): BaseResponse<Unit>

    @GET("/api/v1/member/profile")
    suspend fun getMemberProfile(): BaseResponse<MemberResponse>
}
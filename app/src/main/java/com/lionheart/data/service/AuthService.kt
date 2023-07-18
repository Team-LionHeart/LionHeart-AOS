package com.lionheart.data.service

import com.lionheart.data.model.request.ReissueRequest
import com.lionheart.data.model.request.SignUpRequest
import com.lionheart.data.model.request.SocialLoginRequest
import com.lionheart.data.model.response.AuthTokenResponse
import com.lionheart.data.model.response.BaseResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthService {
    @POST("/api/v1/auth/login")
    suspend fun postLoginSocial(
        @Body socialLoginRequest: SocialLoginRequest
    ): BaseResponse<AuthTokenResponse>

    @POST("/api/v1/auth/logout")
    suspend fun postLogout(): BaseResponse<Unit>

    @POST("/api/v1/auth/reissue")
    suspend fun postReissue(
        @Body reissueRequest: ReissueRequest
    ): BaseResponse<AuthTokenResponse>

    @POST("/api/v1/auth/signup")
    suspend fun postSignUp(
        @Body signUpRequest: SignUpRequest
    ): BaseResponse<AuthTokenResponse>
}
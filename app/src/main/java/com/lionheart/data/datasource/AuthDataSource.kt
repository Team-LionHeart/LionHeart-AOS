package com.lionheart.data.datasource

import com.lionheart.data.model.request.SocialLoginRequest
import com.lionheart.data.model.response.AuthTokenResponse
import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.service.AuthService
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val authService: AuthService
) {
    suspend fun postLoginSocial(
        socialType: String,
        token: String,
        fcmToken: String
    ): BaseResponse<AuthTokenResponse> =
        authService.postLoginSocial(SocialLoginRequest(socialType, token, fcmToken))
}
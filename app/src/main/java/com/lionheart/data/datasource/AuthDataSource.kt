package com.lionheart.data.datasource

import com.lionheart.data.model.request.SignUpRequest
import com.lionheart.data.model.request.SocialLoginRequest
import com.lionheart.data.model.response.AuthTokenResponse
import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.service.AuthService
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val authService: AuthService
) {
    suspend fun socialLogin(socialType: String, token: String, fcmToken: String) =
        authService.postLoginSocial(
            SocialLoginRequest(
                socialType, token, fcmToken
            )
        )

    suspend fun postLoginSocial(
        socialType: String,
        token: String,
        fcmToken: String
    ): BaseResponse<AuthTokenResponse> =
        authService.postLoginSocial(SocialLoginRequest(socialType, token, fcmToken))

    suspend fun signUp(
        socialType: String,
        token: String,
        fcmToken: String,
        pregnantWeeks: Int,
        babyNickname: String
    ): BaseResponse<AuthTokenResponse> =
        authService.postSignUp(SignUpRequest(socialType, token, fcmToken, pregnantWeeks, babyNickname))
}
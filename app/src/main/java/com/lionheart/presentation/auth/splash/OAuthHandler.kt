package com.lionheart.presentation.auth.splash

import android.content.Context
import com.kakao.sdk.auth.model.OAuthToken
import com.kakao.sdk.user.UserApiClient
import com.lionheart.LionOAuthException

object OAuthHandler {
    fun existsKakaoApp(context: Context) = UserApiClient.instance.isKakaoTalkLoginAvailable(context)
    fun kakaoLoginOnApp(context: Context, onSuccess: (OAuthToken) -> Unit) {
        UserApiClient.instance.loginWithKakaoTalk(context) { token, error ->
            if (error != null) throw LionOAuthException("카카오 로그인 중 발생한 비정상적인 에러 (detail : ${error.message})")
            onSuccess(token ?: throw LionOAuthException("카카로 로그인 중 토큰이 정상적으로 넘어오지 않았습니다."))
        }
    }

    fun kakaoLoginOnWeb(context: Context, onSuccess: (OAuthToken) -> Unit) {
        UserApiClient.instance.loginWithKakaoAccount(context) { token, error ->
            if (error != null) throw LionOAuthException("카카오 로그인 중 발생한 비정상적인 에러 (detail : ${error.message})")
            onSuccess(token ?: throw LionOAuthException("카카로 로그인 중 토큰이 정상적으로 넘어오지 않았습니다."))
        }
    }
}

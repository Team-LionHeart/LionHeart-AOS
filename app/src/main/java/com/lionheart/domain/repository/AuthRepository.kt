package com.lionheart.domain.repository

import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.entity.SocialType

interface AuthRepository {
    /**
     * 소셜 로그인
     */
    suspend fun socialLogin(socialType: SocialType, token: String, fcmToken: String): AuthToken

    /**
     * 로그아웃
     */
    suspend fun logout(): Boolean

    /**
     * 토큰 재발급
     */
    suspend fun reissueToken(): AuthToken

    /**
     * 회원가입
     */
    suspend fun signUp(signUpInfo: SignUpInfo): AuthToken
}
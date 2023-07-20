package com.lionheart.domain.repository

import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.entity.Authentication
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.entity.SocialType
import kotlinx.coroutines.flow.Flow

interface AnonymousRepository {
    /**
     * 소셜 로그인
     */
    suspend fun socialLogin(
        socialType: SocialType,
        token: String,
        fcmToken: String
    ): Flow<AuthToken>

    /**
     * 회원가입
     */
    suspend fun signUp(signUpInfo: SignUpInfo): AuthToken
}
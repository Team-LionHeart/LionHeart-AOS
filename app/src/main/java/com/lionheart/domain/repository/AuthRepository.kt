package com.lionheart.domain.repository

import com.lionheart.domain.entity.AuthToken

interface AuthRepository {
    /**
     * 로그아웃
     */
    suspend fun logout(): Boolean

    /**
     * 토큰 재발급
     */
    suspend fun reissueToken(): AuthToken
}
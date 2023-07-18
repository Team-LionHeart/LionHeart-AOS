package com.lionheart.domain.repository

import com.lionheart.domain.entity.Challenge

interface ChallengeRepository {
    /**
     * 챌린지 정보 조회
     */
    suspend fun getProgress(): Challenge
}
package com.lionheart.data.repository

import com.lionheart.domain.entity.Challenge
import com.lionheart.domain.repository.ChallengeRepository
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
//    private val challengeDataSource: ChallengeDataSource
): ChallengeRepository {
    override suspend fun getProgress(): Challenge {
        TODO("Not yet implemented")
    }
}
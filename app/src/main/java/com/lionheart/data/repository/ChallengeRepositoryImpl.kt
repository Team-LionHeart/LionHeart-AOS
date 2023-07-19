package com.lionheart.data.repository

import com.lionheart.data.datasource.ChallengeDataSource
import com.lionheart.domain.entity.Challenge
import com.lionheart.domain.repository.ChallengeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val challengeDataSource: ChallengeDataSource,
) : ChallengeRepository {
    override suspend fun getProgress(): Flow<Challenge> = flow {
        challengeDataSource.getChallengeProgress().data?.toChallengeEntity()?.let { emit(it) }
    }
}

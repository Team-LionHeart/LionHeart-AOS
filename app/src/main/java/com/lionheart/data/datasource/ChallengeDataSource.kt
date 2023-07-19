package com.lionheart.data.datasource

import com.lionheart.data.service.ChallengeService
import javax.inject.Inject

class ChallengeDataSource @Inject constructor(
    private val challengeService: ChallengeService
) {
    suspend fun getChallengeProgress() = challengeService.getChallengeProgress()
}
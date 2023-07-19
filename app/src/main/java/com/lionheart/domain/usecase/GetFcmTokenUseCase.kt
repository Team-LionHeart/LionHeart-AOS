package com.lionheart.domain.usecase

import com.lionheart.domain.repository.AuthRepository
import javax.inject.Inject

class GetFcmTokenUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    operator fun invoke(setFCMToken: (String) -> Unit) = authRepository.getFCMToken(setFCMToken)
}
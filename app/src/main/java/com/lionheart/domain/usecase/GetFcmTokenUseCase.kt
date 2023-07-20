package com.lionheart.domain.usecase

import com.lionheart.domain.repository.FcmRepository
import javax.inject.Inject

class GetFcmTokenUseCase @Inject constructor(
    private val fcmRepository: FcmRepository
) {
    operator fun invoke(setFCMToken: (String) -> Unit) = fcmRepository.getFCMToken(setFCMToken)
}
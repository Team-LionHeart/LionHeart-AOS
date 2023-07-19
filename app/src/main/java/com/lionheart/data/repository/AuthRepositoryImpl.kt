package com.lionheart.data.repository

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.lionheart.data.datasource.AuthDataSource
import com.lionheart.domain.entity.AuthToken
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.entity.SocialType
import com.lionheart.domain.repository.AuthRepository
import timber.log.Timber
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
): AuthRepository {
    override suspend fun socialLogin(
        socialType: SocialType,
        token: String,
        fcmToken: String
    ): AuthToken {
        TODO("Not yet implemented")
    }

    override suspend fun logout(): Boolean {
        TODO("Not yet implemented")
    }

    override fun getFCMToken(setFCMToken: (String) -> Unit) {
        FirebaseMessaging.getInstance().token.addOnCompleteListener(
            OnCompleteListener { task ->
                if (!task.isSuccessful) {
                    Timber.e("Fetching FCM registration token failed", task.exception)
                    return@OnCompleteListener
                }
                setFCMToken(task.result)
            }
        )
    }

    override suspend fun reissueToken(): AuthToken {
        TODO("Not yet implemented")
    }

    override suspend fun signUp(signUpInfo: SignUpInfo): AuthToken {
        TODO("Not yet implemented")
    }
}
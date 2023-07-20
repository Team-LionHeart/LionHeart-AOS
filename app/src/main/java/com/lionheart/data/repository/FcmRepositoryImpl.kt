package com.lionheart.data.repository

import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.messaging.FirebaseMessaging
import com.lionheart.domain.repository.FcmRepository
import timber.log.Timber

class FcmRepositoryImpl : FcmRepository {
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
}
package com.lionheart

import android.app.Application
import com.kakao.sdk.common.KakaoSdk
import com.lionheart.BuildConfig.KAKAO_API_KEY
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class LionHeart: Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        KakaoSdk.init(this, KAKAO_API_KEY)
    }
}
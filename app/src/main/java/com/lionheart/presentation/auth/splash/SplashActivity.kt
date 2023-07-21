package com.lionheart.presentation.auth.splash

import android.content.Intent
import androidx.activity.viewModels
import androidx.core.view.postOnAnimationDelayed
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.data.LionDataStore.dataStore
import com.lionheart.databinding.ActivitySplashBinding
import com.lionheart.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SplashActivity : BindingActivity<ActivitySplashBinding>(R.layout.activity_splash) {
    private val viewModel: SplashViewModel by viewModels()
    override fun constructLayout() {
        viewModel.checkAutoLogin()
        binding.ltTemp.playAnimation()
    }

    override fun addListeners() {
        binding.ltTemp.postOnAnimationDelayed(3000) {
            viewModel.autoLogin.observe(this@SplashActivity) { autoLogin ->
                if (autoLogin) {
                    startActivity(Intent(this@SplashActivity, MainActivity::class.java))
                } else {
                    startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
                }

                finish()
            }
        }
    }
}
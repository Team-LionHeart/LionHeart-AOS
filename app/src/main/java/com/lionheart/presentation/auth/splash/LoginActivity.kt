package com.lionheart.presentation.auth.splash

import android.content.Intent
import androidx.activity.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityLoginBinding
import com.lionheart.presentation.MainActivity
import com.lionheart.presentation.auth.onboarding.PregnantWeekActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
    private val viewModel: LoginViewModel by viewModels()
    override fun constructLayout() {
        super.constructLayout()
    }

    override fun addListeners() {
        onTouchKakaoLoginButton()
    }

    private fun onTouchKakaoLoginButton() {
        binding.layoutLoginKakao.setOnClickListener {
            if (OAuthHandler.existsKakaoApp(this@LoginActivity)) {
                OAuthHandler.kakaoLoginOnApp(this@LoginActivity) {
                    callSignUp(
                        oauthAccessToken = it.accessToken,
                        oauthRefreshToken = it.refreshToken
                    )
                }
            } else {
                OAuthHandler.kakaoLoginOnWeb(this@LoginActivity) {
                    callSignUp(
                        oauthAccessToken = it.accessToken,
                        oauthRefreshToken = it.refreshToken
                    )
                }
            }
        }
    }

    private fun callSignUp(oauthAccessToken: String, oauthRefreshToken: String) {
        viewModel.loginOnApi(oauthAccessToken, oauthRefreshToken,
            goMain = {
                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            },
            goOnBoarding = { socialToken ->
                val toOnBoarding = Intent(this@LoginActivity, PregnantWeekActivity::class.java)
                toOnBoarding.putExtra("socialToken", socialToken)
                startActivity(toOnBoarding)
                finish()
            }
        )
    }
}
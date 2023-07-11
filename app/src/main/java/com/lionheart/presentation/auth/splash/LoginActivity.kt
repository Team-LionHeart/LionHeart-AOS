package com.lionheart.presentation.auth.splash

import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityLoginBinding

class LoginActivity : BindingActivity<ActivityLoginBinding>(R.layout.activity_login) {
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
        // TODO : sign up api 연동
        print("")
    }
}
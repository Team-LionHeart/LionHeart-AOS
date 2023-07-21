package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import androidx.activity.viewModels
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.core.uistate.UiState
import com.lionheart.databinding.ActivityRegisterDoneBinding
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.presentation.MainActivity
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.last
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import timber.log.Timber

@AndroidEntryPoint
class RegisterDoneActivity :
    BindingActivity<ActivityRegisterDoneBinding>(R.layout.activity_register_done) {
    private val viewModel by viewModels<RegisterDoneViewModel>()

    override fun constructLayout() {
        binding.tvRegisterDoneTitle.text =
            resources.getString(R.string.onboarding_register_done, intent.getStringExtra("name"))
        getSignUpState()
    }

    override fun addListeners() {
        binding.btnRegisterDone.setOnClickListener {
            // TODO: 토큰 값도 넣어주기
//            viewModel.signup(SignUpInfo(
//                intent.getStringExtra("week"),
//                intent.getStringExtra("name")
//            ))
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }.run(::startActivity)
        }
    }

    private fun getSignUpState() {
        viewModel.signUpState.flowWithLifecycle(lifecycle).onEach { event ->
            if (event is UiState.Failure) {
                Timber.tag("signup state").d(event.code.toString())
            }
        }.launchIn(lifecycleScope)
    }
}
package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityOnboardingBinding
import com.lionheart.presentation.auth.splash.LoginActivity
import timber.log.Timber

class OnboardingActivity :
    BindingActivity<ActivityOnboardingBinding>(R.layout.activity_onboarding) {
    private val viewModel by viewModels<OnboardingViewModel>()

    override fun addListeners() {
        binding.btnOnboardingNext.setOnClickListener {
            when (it.tag) {
                // 임신 주수 뷰에서
                0 -> {
                    findNavController(R.id.fcv_onboarding).navigate(R.id.action_pregnant_week_fragment_to_baby_name_fragment)
                    it.tag = viewModel.goToNext()
                    Timber.d("next : 임신 주수 -> 태명 / ${it.tag}")
                }
                // 태명 뷰에서
                1 -> {
                    Intent(this, RegisterDoneActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }.run(::startActivity)
                    Timber.d("next : 태명 -> 완료! / ${it.tag}")
                }
            }
        }
        binding.btnOnboardingBack.setOnClickListener {
            it.tag = binding.btnOnboardingNext.tag
            when (it.tag) {
                // 임신 주수 뷰에서
                0 -> {
                    Intent(this, LoginActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }.run(::startActivity)
                    Timber.d("back : 임신 주수 -> 로그인 / ${it.tag}")
                }
                // 태명 뷰에서
                1 -> {
                    findNavController(R.id.fcv_onboarding).navigate(R.id.action_baby_name_fragment_to_pregnant_week_fragment)
                    it.tag = viewModel.goToPrevious()
                    binding.btnOnboardingNext.tag = it.tag
                    Timber.d("back : 태명 -> 임신 주수 / ${it.tag}")
                }
            }
        }
    }
}
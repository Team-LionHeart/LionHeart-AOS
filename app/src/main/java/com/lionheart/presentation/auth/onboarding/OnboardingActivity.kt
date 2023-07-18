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
    private val navHostFragment by lazy { supportFragmentManager.findFragmentById(R.id.fcv_onboarding) as NavHostFragment }

    override fun addListeners() {
        navHostFragment.navController.addOnDestinationChangedListener { _, dest, _ ->
            when (dest.label) {
                "pregnant_week_fragment" -> {
                    with (binding) {
                        progressOnboarding.progress = 50
                        btnOnboardingNext.tag = 0
                        btnOnboardingBack.tag = 0
                    }
                }
                "baby_name_fragment" -> {
                    with(binding) {
                        progressOnboarding.progress = 100
                        btnOnboardingNext.tag = 1
                        btnOnboardingBack.tag = 1
                    }
                }
                else -> binding.progressOnboarding.progress = 0
            }
        }
        binding.btnOnboardingNext.setOnClickListener {
            when (it.tag) {
                // 임신 주수 뷰에서
                0 -> {
                    findNavController(R.id.fcv_onboarding).navigate(R.id.action_pregnant_week_fragment_to_baby_name_fragment)
                }
                // 태명 뷰에서
                1 -> {
                    Intent(this, RegisterDoneActivity::class.java).apply {
                        flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    }.run(::startActivity)
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
                }
                // 태명 뷰에서
                1 -> {
                    findNavController(R.id.fcv_onboarding).navigate(R.id.action_baby_name_fragment_to_pregnant_week_fragment)
                }
            }
        }
    }
}
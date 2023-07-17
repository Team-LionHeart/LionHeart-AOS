package com.lionheart.presentation.auth.onboarding

import androidx.lifecycle.ViewModel

class OnboardingViewModel: ViewModel() {
    var step: Int = 0

    fun goToNext(): Int {
        if(step < 2) { step++ }
        return step
    }
    fun goToPrevious(): Int {
        if(step > 0) { step-- }
        return step
    }
}
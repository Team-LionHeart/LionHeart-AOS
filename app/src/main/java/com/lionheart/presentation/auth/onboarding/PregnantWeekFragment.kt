package com.lionheart.presentation.auth.onboarding

import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentPregnantWeekBinding

class PregnantWeekFragment : BindingFragment<FragmentPregnantWeekBinding>(R.layout.fragment_pregnant_week) {
    override fun constructLayout() {
        binding.etPregnantWeek.requestFocus()
    }
}
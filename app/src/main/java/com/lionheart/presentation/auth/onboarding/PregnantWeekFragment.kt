package com.lionheart.presentation.auth.onboarding

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.fragment.app.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentPregnantWeekBinding

class PregnantWeekFragment : BindingFragment<FragmentPregnantWeekBinding>(R.layout.fragment_pregnant_week) {
    private val viewModel by viewModels<PregnantWeekViewModel>()

    override fun constructLayout() {
        with(binding) {
            // databinding
            vm = viewModel
            lifecycleOwner = viewLifecycleOwner
            // ui
            tvPregnantWeekWarning.visibility = View.INVISIBLE
            etPregnantWeek.requestFocus()
        }
    }

    override fun addListeners() {
        binding.etPregnantWeek.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.tvPregnantWeekWarning.text = "1에서 40 사이의 숫자를 입력해주세요."
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
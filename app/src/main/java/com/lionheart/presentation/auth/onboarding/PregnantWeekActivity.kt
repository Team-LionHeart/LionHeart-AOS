package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityPregnantWeekBinding
import timber.log.Timber

class PregnantWeekActivity :
    BindingActivity<ActivityPregnantWeekBinding>(R.layout.activity_pregnant_week) {
    private val viewModel by viewModels<PregnantWeekViewModel>()

    override fun constructLayout() {
        with(binding) {
            // databinding
            vm = viewModel
            // ui
            progressPregnantWeek.progress = 50
            tvPregnantWeekWarning.visibility = View.INVISIBLE
            etPregnantWeek.requestFocus()
        }
    }

    override fun addListeners() {
        watchInput()
        binding.btnPregnantWeekNext.setOnClickListener {
            Timber.d("pregnant week : ${binding.etPregnantWeek.text}")
            Intent(this, BabyNameActivity::class.java).apply {
                putExtra("week", binding.etPregnantWeek.text.toString())
                putExtra("socialToken", intent.getStringExtra("socialToken"))
            }.run(::startActivity)
        }
        binding.layoutPregnantWeekToolbar.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun watchInput() {
        binding.etPregnantWeek.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.tvPregnantWeekWarning.text = "1에서 40 사이의 숫자를 입력해주세요."
                if (viewModel.isValidWeek.value == true) {
                    binding.btnPregnantWeekNext.visibility = View.VISIBLE
                } else {
                    binding.btnPregnantWeekNext.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
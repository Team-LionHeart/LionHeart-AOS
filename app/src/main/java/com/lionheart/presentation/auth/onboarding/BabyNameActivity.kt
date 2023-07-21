package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.activity.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityBabyNameBinding
import timber.log.Timber

class BabyNameActivity : BindingActivity<ActivityBabyNameBinding>(R.layout.activity_baby_name) {
    private val viewModel by viewModels<BabyNameViewModel>()

    override fun constructLayout() {
        with(binding) {
            // databinding
            vm = viewModel
            // ui
            progressBabyName.progress = 100
            tvBabyNameWarning.visibility = View.INVISIBLE
            btnBabyNameClear.visibility = View.INVISIBLE
        }
    }

    override fun addListeners() {
        watchInput()
        binding.btnBabyNameClear.setOnClickListener {
            binding.etBabyName.text.clear()
        }
        binding.btnBabyNameNext.setOnClickListener {
            Timber.d("pregnant week : ${intent.getStringExtra("week")}")
            Intent(this, RegisterDoneActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                putExtra("week", intent.getStringExtra("week"))
                putExtra("name", binding.etBabyName.text.toString())
            }.run(::startActivity)
        }
        binding.layoutBabyNameToolbar.btnBack.setOnClickListener {
            finish()
        }
    }

    private fun watchInput() {
        binding.etBabyName.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.tvBabyNameWarning.visibility = View.VISIBLE
                binding.btnBabyNameClear.visibility = View.VISIBLE
                if (viewModel.isValidName.value == true) {
                    binding.btnBabyNameNext.visibility = View.VISIBLE
                } else {
                    binding.btnBabyNameNext.visibility = View.GONE
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}
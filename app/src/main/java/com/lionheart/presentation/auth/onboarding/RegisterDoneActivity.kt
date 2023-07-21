package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityRegisterDoneBinding
import com.lionheart.presentation.MainActivity

class RegisterDoneActivity :
    BindingActivity<ActivityRegisterDoneBinding>(R.layout.activity_register_done) {

    override fun constructLayout() {
        binding.tvRegisterDoneTitle.text =
            resources.getString(R.string.onboarding_register_done, intent.getStringExtra("name"))
    }

    override fun addListeners() {
        binding.btnRegisterDone.setOnClickListener {
            // 서버통신
            Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            }.run(::startActivity)
        }
    }
}
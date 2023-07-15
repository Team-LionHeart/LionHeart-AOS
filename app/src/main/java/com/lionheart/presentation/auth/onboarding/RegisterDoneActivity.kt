package com.lionheart.presentation.auth.onboarding

import android.content.Intent
import com.lionheart.R
import com.lionheart.core.binding.BindingActivity
import com.lionheart.databinding.ActivityRegisterDoneBinding
import com.lionheart.presentation.MainActivity

class RegisterDoneActivity :
    BindingActivity<ActivityRegisterDoneBinding>(R.layout.activity_register_done) {
    override fun addListeners() {
        binding.btnRegisterDone.setOnClickListener {
            Intent(this, MainActivity::class.java).run(::startActivity)
        }
    }
}
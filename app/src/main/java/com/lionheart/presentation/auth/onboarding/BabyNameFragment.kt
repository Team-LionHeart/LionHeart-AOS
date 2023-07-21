package com.lionheart.presentation.auth.onboarding

import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import androidx.fragment.app.viewModels
import com.lionheart.R
import com.lionheart.core.binding.BindingFragment
import com.lionheart.databinding.FragmentBabyNameBinding
import com.lionheart.domain.entity.BabyNameWarning
import timber.log.Timber

class BabyNameFragment : BindingFragment<FragmentBabyNameBinding>(R.layout.fragment_baby_name) {
    private val viewModel by viewModels<BabyNameViewModel>()

    override fun constructLayout() {
        with(binding) {
            // databinding
            vm = viewModel
            // ui
            tvBabyNameWarning.visibility = View.INVISIBLE
            btnBabyNameClear.visibility = View.INVISIBLE
        }
    }

    override fun addListeners() {
        binding.etBabyName.addTextChangedListener(object: TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                binding.tvBabyNameWarning.visibility = View.VISIBLE
                binding.btnBabyNameClear.visibility = View.VISIBLE
                if (viewModel.isValidName.value == true) {
                    activity!!.findViewById<Button>(R.id.btn_onboarding_next).visibility = View.VISIBLE
                } else {
                    activity!!.findViewById<Button>(R.id.btn_onboarding_next).visibility = View.GONE
                }
            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
        binding.btnBabyNameClear.setOnClickListener {
            binding.etBabyName.text.clear()
        }
    }
}
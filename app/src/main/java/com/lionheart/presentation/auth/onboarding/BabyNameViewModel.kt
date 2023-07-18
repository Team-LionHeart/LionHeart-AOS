package com.lionheart.presentation.auth.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import com.lionheart.domain.entity.BabyNameWarning
import timber.log.Timber
import java.util.regex.Pattern

class BabyNameViewModel : ViewModel() {
    val _name = MutableLiveData("")
    private val name: String
        get() = _name.value?.trim() ?: ""

    val message = MutableLiveData("")

    val setMessage: LiveData<String> = _name.map { input -> setNameMessage(checkName(input)) }
    val isValidName: LiveData<Boolean> = _name.map { input -> isValidNameFormat(checkName(input)) }

    private fun checkName(name: String): BabyNameWarning {
        if (name.isEmpty()) return BabyNameWarning.NO_INPUT
        if (name.matches(NAME_PATTERN.toRegex())) {
            if (name.length in 1..10) return BabyNameWarning.GUIDE
            return BabyNameWarning.OVER_TEN
        }
        return BabyNameWarning.OVER_TEN
    }

    private fun setNameMessage(status: BabyNameWarning): String = status.message

    private fun isValidNameFormat(status: BabyNameWarning): Boolean {
        if (status == BabyNameWarning.GUIDE) return true
        return false
    }

    companion object {
        private const val NAME_PATTERN = "^[ㄱ-ㅎ가-힣a-zA-Z0-9]+$"
    }
}
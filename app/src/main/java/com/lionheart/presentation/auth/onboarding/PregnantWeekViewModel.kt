package com.lionheart.presentation.auth.onboarding

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map

class PregnantWeekViewModel : ViewModel() {
    val week = MutableLiveData("")
    val isValidWeek: LiveData<Boolean> = week.map { input -> isValidWeekFormat(input) }

    private fun isValidWeekFormat(week: String): Boolean {
        val weekValue = week.toIntOrNull()
        return weekValue in 1..40
    }
}
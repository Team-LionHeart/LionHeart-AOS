package com.lionheart.presentation.auth.splash

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.domain.usecase.GetFcmTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getFcmTokenUseCase: GetFcmTokenUseCase
) : ViewModel() {
    private val fcmToken = MutableLiveData<String>()

    init {
        getFCMToken()
    }

    private fun getFCMToken() {
        viewModelScope.launch {
            getFcmTokenUseCase { getFcmToken -> fcmToken.value = getFcmToken }
        }
    }
}
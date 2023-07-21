package com.lionheart.presentation.auth.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.domain.repository.DataStoreRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor(
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    private val _autoRegistration = MutableLiveData<Boolean>()
    val autoLogin: LiveData<Boolean>
        get() = _autoRegistration

    fun checkAutoLogin() {
        viewModelScope.launch {
            _autoRegistration.value = dataStoreRepository.getAuthentication()?.let { true } ?: false
        }
    }
}
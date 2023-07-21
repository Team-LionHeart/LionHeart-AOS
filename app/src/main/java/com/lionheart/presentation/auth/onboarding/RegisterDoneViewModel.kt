package com.lionheart.presentation.auth.onboarding

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.domain.entity.Authentication
import com.lionheart.domain.entity.SignUpInfo
import com.lionheart.domain.repository.AnonymousRepository
import com.lionheart.presentation.search.category.SearchDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class RegisterDoneViewModel @Inject constructor(
    private val anonymousRepository: AnonymousRepository
) : ViewModel() {
    private val _signUpState = MutableSharedFlow<UiState<SignUpInfo>>()
    val signUpState = _signUpState.asSharedFlow()

    private val _apiAccessToken = MutableSharedFlow<UiState<String>>()
    val apiAccessToken = _apiAccessToken.asSharedFlow()

    private val _apiRefreshToken = MutableSharedFlow<UiState<String>>()
    val apiRefreshToken = _apiRefreshToken.asSharedFlow()

    fun signup(signUpInfo: SignUpInfo) {
        viewModelScope.launch {
            anonymousRepository.signUp(signUpInfo)
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _signUpState.emit(UiState.Failure(error.code()))
                        }
                        is NetworkErrorException -> {
                            // TODO
                        }
                        else -> {
                            LionUnKnownException("알 수 없는 에러 발생 : $error")
                        }
                    }
                }
                .collect { response ->
                    _apiAccessToken.emit(UiState.Success(response.accessToken))
                    response.refreshToken?.let { _apiRefreshToken.emit(UiState.Success(it)) }
                }
        }
    }
}
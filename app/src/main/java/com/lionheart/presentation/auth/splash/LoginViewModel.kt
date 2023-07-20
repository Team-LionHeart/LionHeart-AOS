package com.lionheart.presentation.auth.splash

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.domain.entity.Authentication
import com.lionheart.domain.entity.SocialType
import com.lionheart.domain.repository.AnonymousRepository
import com.lionheart.domain.repository.DataStoreRepository
import com.lionheart.domain.usecase.GetFcmTokenUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val getFcmTokenUseCase: GetFcmTokenUseCase,
    private val anonymousRepository: AnonymousRepository,
    private val dataStoreRepository: DataStoreRepository
) : ViewModel() {
    private val _apiAccessToken = MutableSharedFlow<UiState<String>>()
    val apiAccessToken = _apiAccessToken.asSharedFlow()

    private val _apiRefreshToken = MutableSharedFlow<UiState<String>>()
    val apiRefreshToken = _apiRefreshToken.asSharedFlow()

    fun loginOnApi(
        accessToken: String,
        refreshToken: String,
        goMain: () -> Unit,
        goOnBoarding: () -> Unit
    ) {
        viewModelScope.launch {
            getFcmTokenUseCase { getFCMToken ->
                viewModelScope.launch {
                    anonymousRepository.socialLogin(SocialType.KAKAO, accessToken, getFCMToken)
                        .catch { error ->
                            when (error) {
                                is HttpException -> {
                                    if (error.code() == 404) {
                                        goOnBoarding.invoke()
                                    }
                                    _apiAccessToken.emit(UiState.Failure(error.code()))
                                }

                                is NetworkErrorException -> {
                                    Log.e("", "")
//                            _getProgress.emit(Failure(NETWORK_ERROR))
                                }

                                else -> {
                                    LionUnKnownException("알 수 없는 에러 발생 : $error")
                                }
                            }
                        }.collect { response ->
                            _apiAccessToken.emit(UiState.Success(response.accessToken))
                            response.refreshToken?.let { _apiRefreshToken.emit(UiState.Success(it)) }
                            dataStoreRepository.setAuthentication(
                                Authentication(
                                    accessToken,
                                    refreshToken
                                )
                            )
                            goMain.invoke()
                        }
                }
            }
        }
    }
}
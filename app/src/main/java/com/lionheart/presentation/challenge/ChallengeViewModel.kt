package com.lionheart.presentation.challenge

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.Challenge
import com.lionheart.domain.repository.ChallengeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(
    private val challengeRepository: ChallengeRepository,
) : ViewModel() {
    private val _getProgress = MutableSharedFlow<UiState<Challenge>>()
    val getProgress = _getProgress.asSharedFlow()

    fun getChallengeProgress() {
        viewModelScope.launch {
            challengeRepository.getProgress()
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _getProgress.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
//                            _getProgress.emit(Failure(NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 에러 발생 : $error")
                        }
                    }
                }
                .collect { response ->
                    _getProgress.emit(Success(response))
                }
        }
    }
}

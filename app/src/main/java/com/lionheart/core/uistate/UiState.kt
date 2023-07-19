package com.lionheart.core.uistate

sealed class UiState<out T> {
    data class Success<T>(val data: T) : UiState<T>()
    data class Failure(val code: Int?) : UiState<Nothing>()
}

package com.lionheart.presentation.today

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.Today
import com.lionheart.domain.repository.ArticleRepository
import com.lionheart.presentation.search.category.SearchDetailViewModel.Companion.NETWORK_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class TodayViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val _getTodayArticleState = MutableSharedFlow<UiState<Today>>()
    val getTodayArticleState = _getTodayArticleState.asSharedFlow()

    init {
        getTodayArticle()
    }

    private fun getTodayArticle() {
        viewModelScope.launch {
            articleRepository.getTodayArticle()
                .catch { error ->
                    when(error) {
                        is HttpException -> {
                            _getTodayArticleState.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
                            _getTodayArticleState.emit(Failure(NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 에러 : $error")
                        }
                    }
                }
                .collect { response ->
                    _getTodayArticleState.emit(Success(response))
                }
        }
    }
}

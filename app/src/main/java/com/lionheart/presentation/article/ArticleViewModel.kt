package com.lionheart.presentation.article

import android.accounts.NetworkErrorException
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.ArticleDetail
import com.lionheart.domain.repository.ArticleRepository
import com.lionheart.presentation.search.category.SearchDetailViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val _getArticleDetailState = MutableSharedFlow<UiState<ArticleDetail>>()
    val getArticleDetailState = _getArticleDetailState.asSharedFlow()

    fun getArticleDetail(articleId: Int) {
        viewModelScope.launch {
            Timber.tag("안녕").d(articleId.toString())
            articleRepository.getArticleDetail(articleId)
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _getArticleDetailState.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
                            _getArticleDetailState.emit(Failure(SearchDetailViewModel.NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 에러 : $error")
                        }
                    }
                    Timber.tag("뭐하는거니").d(error)
                }
                .collect { response ->
                    Log.d("안녕하세요요요요요", response.toString())
                    _getArticleDetailState.emit(Success(response))
                }
        }
    }
}

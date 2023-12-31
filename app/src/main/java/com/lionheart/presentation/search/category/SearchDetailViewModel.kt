package com.lionheart.presentation.search.category

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.ArticleCategory
import com.lionheart.domain.entity.ArticleDetail
import com.lionheart.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SearchDetailViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val _getCategoryArticleState = MutableSharedFlow<UiState<List<Article>>>()
    val getCategoryArticleState = _getCategoryArticleState.asSharedFlow()

    fun getCategoryArticle(category: ArticleCategory) {
        viewModelScope.launch {
            articleRepository.getArticleByCategory(category)
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _getCategoryArticleState.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
                            _getCategoryArticleState.emit(Failure(NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 문제가 발생하였습니다")
                        }
                    }
                }
                .collect { response ->
                    _getCategoryArticleState.emit(Success(response))
                }
        }
    }

    fun switchBookmark(articleId: Long, switching: Boolean) {
        viewModelScope.launch {
            articleRepository.switchBookmark(articleId, switching)
        }
    }

    companion object {
        val NETWORK_ERROR = 0
    }
}

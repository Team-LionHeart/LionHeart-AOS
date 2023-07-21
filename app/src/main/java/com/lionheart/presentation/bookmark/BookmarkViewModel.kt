package com.lionheart.presentation.bookmark

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.BookmarkArticle
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
class BookmarkViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val _bookmarkArticleState = MutableSharedFlow<UiState<BookmarkArticle>>()
    val bookmarkArticleState = _bookmarkArticleState.asSharedFlow()

    fun getBookmarkArticle() {
        viewModelScope.launch {
            articleRepository.getBookmarks().catch { error ->
                when (error) {
                    is HttpException -> {
                        _bookmarkArticleState.emit(Failure(error.code()))
                    }

                    is NetworkErrorException -> {
                        _bookmarkArticleState.emit(Failure(NETWORK_ERROR))
                    }

                    else -> {
                        LionUnKnownException("알 수 없는 에러 발생 : $error")
                    }
                }
            }.collect { response ->
                _bookmarkArticleState.emit(Success(response))
            }
        }
    }

    fun switchBookmark(articleId: Long, switching: Boolean) {
        viewModelScope.launch {
            articleRepository.switchBookmark(articleId, switching)
        }
    }
}

package com.lionheart.presentation.course

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.CourseWeek
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
class CourseDetailViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    private val _getCourseArticleState = MutableSharedFlow<UiState<List<Article>>>()
    val getCourseArticleState = _getCourseArticleState.asSharedFlow()

    fun getCourseArticle(week: Long) {
        viewModelScope.launch {
            articleRepository.getWeeklyArticle(week)
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _getCourseArticleState.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
                            _getCourseArticleState.emit(Failure(NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 에러가 발생하였습니다 : $error")
                        }
                    }
                }
                .collect { response ->
                    _getCourseArticleState.emit(Success(response))
                }
        }
    }

    fun switchBookmark(articleId: Long, switching: Boolean) {
        viewModelScope.launch {
            articleRepository.switchBookmark(articleId, switching)
        }
    }
}

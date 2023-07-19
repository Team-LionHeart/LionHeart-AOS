package com.lionheart.presentation.search.category

import android.accounts.NetworkErrorException
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.domain.entity.Article
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.domain.entity.ArticleCategory
import com.lionheart.domain.repository.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class SearchDetailViewModel @Inject constructor(
    private val articleRepository: ArticleRepository,
) : ViewModel() {
    val mockArticleList = listOf<Article>(
        Article(
            "안녕",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕1",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕2",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕3",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕4",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕5",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
        Article(
            "안녕6",
            "https://github.com/SeonHwan-Kim/VelogInMobile/assets/96679633/53d3618b-2978-47f0-a2fd-8c8f98435047",
            "안나ㅏ여네앎ㄴ;이ㅏㄹ;ㅁㄴ아ㅣㅗ마너ㅣㅇ포ㅜㅁ나어륨ㄴ아ㅓㅗㄹ휴마ㅓㄴㅇ류피져ㅏㅓㅇㅎ늎ㅊ ㅠ미ㅏㅕㄴㅇㄹ",
            9,
            false,
            listOf("hi", "hello", "bye"),
        ),
    )

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

    companion object {
        val NETWORK_ERROR = 0
    }
}

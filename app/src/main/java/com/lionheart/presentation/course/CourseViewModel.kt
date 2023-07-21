package com.lionheart.presentation.course

import android.accounts.NetworkErrorException
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.LionUnKnownException
import com.lionheart.core.uistate.UiState
import com.lionheart.core.uistate.UiState.Failure
import com.lionheart.core.uistate.UiState.Success
import com.lionheart.data.repository.CourseRepositoryImpl
import com.lionheart.domain.entity.Course
import com.lionheart.domain.entity.CurriculumProgress
import com.lionheart.domain.repository.ArticleRepository
import com.lionheart.domain.repository.CourseRepository
import com.lionheart.domain.repository.CurriculumRepository
import com.lionheart.presentation.search.category.SearchDetailViewModel.Companion.NETWORK_ERROR
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class CourseViewModel @Inject constructor(
    private val curriculumRepository: CurriculumRepository,
) : ViewModel() {
    private val _courseList: MutableLiveData<List<Course>> = MutableLiveData<List<Course>>()
    val courseList: LiveData<List<Course>>
        get() = _courseList

    private val _courseProgressState = MutableSharedFlow<UiState<CurriculumProgress>>()
    val courseProgressState = _courseProgressState.asSharedFlow()

    private val courseRepository: CourseRepository by lazy {
        CourseRepositoryImpl()
    }

    fun setData() {
        viewModelScope.launch {
            _courseList.value = courseRepository.getCourseWeekly()
        }
    }

    //
    fun getCourseProgress() {
        viewModelScope.launch {
            curriculumRepository.getProgress()
                .catch { error ->
                    when (error) {
                        is HttpException -> {
                            _courseProgressState.emit(Failure(error.code()))
                        }

                        is NetworkErrorException -> {
                            _courseProgressState.emit(Failure(NETWORK_ERROR))
                        }

                        else -> {
                            LionUnKnownException("알 수 없는 문제 발생 : $error")
                        }
                    }
                }
                .collect { response ->
                    _courseProgressState.emit(Success(response))
                }
        }
    }

    fun getScrollStartPosition(week: Int): Int {
        if (week == 40) return week + (week / 4) - 5
        return week + (week / 4) - 4
    }
}

package com.lionheart.presentation.course

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.lionheart.domain.entity.Lion
import com.lionheart.domain.repository.LionRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class WeeklyCourseViewModel @Inject constructor(
    private val lionRepository: LionRepository
) : ViewModel() {
    private val _exampleData = MutableLiveData<Lion>()
    val exampleData: LiveData<Lion> get() = _exampleData

    fun getExampleData() {
        viewModelScope.launch {
            lionRepository.getArticleList(1)
                .onSuccess { response ->
                    _exampleData.value = response
                }
                .onFailure {
                    Timber.tag("getExampleDataFailure").d(it)
                }
        }
    }
}
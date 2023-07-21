package com.lionheart.data.datasource

import com.lionheart.data.service.CurriculumService
import javax.inject.Inject

class CurriculumDataSource @Inject constructor(
    private val curriculumService: CurriculumService
) {
    suspend fun getCurriculumProgress() =
        curriculumService.getCurriculumProgress()
}
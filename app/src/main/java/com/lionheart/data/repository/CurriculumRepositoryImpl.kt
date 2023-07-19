package com.lionheart.data.repository

import com.lionheart.domain.repository.CurriculumRepository
import javax.inject.Inject

class CurriculumRepositoryImpl @Inject constructor(
//    private val curriculumDataSource: CurriculumDataSource
): CurriculumRepository {
    override suspend fun getProgress() {
        TODO("Not yet implemented")
    }
}
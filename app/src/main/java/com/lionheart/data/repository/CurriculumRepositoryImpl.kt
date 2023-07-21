package com.lionheart.data.repository

import com.lionheart.data.datasource.CurriculumDataSource
import com.lionheart.domain.entity.CurriculumProgress
import com.lionheart.domain.repository.CurriculumRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CurriculumRepositoryImpl @Inject constructor(
    private val curriculumDataSource: CurriculumDataSource,
) : CurriculumRepository {
    override suspend fun getProgress(): Flow<CurriculumProgress> = flow {
        curriculumDataSource.getCurriculumProgress().data?.toCurriculumProgressEntity()
            ?.let { emit(it) }
    }
}

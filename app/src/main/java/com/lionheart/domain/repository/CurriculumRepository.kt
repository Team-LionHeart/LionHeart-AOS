package com.lionheart.domain.repository

import com.lionheart.domain.entity.CurriculumProgress
import kotlinx.coroutines.flow.Flow

interface CurriculumRepository {
    /**
     * TODO : 응답값은 수민이 커리큘럼 작업에 맞춰 entity
     * 커리큘럼 진척도 조회
     */
    suspend fun getProgress(): Flow<CurriculumProgress>
}

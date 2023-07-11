package com.lionheart.data.repository

import com.lionheart.data.datasource.LionDataSource
import com.lionheart.domain.entity.Lion
import com.lionheart.domain.repository.LionRepository
import javax.inject.Inject

class LionRepositoryImpl @Inject constructor(
    private val lionDataSource: LionDataSource,
) : LionRepository {
    // TODO: 예외처리
    override suspend fun getArticleList(week: Int): Result<Lion> =
        runCatching { lionDataSource.getArticleList(week).data!!.toLion() }

    override suspend fun getArticleDetail(articleId: Int): Result<Lion> =
        runCatching { lionDataSource.getArticleList(articleId).data!!.toLion() }
}

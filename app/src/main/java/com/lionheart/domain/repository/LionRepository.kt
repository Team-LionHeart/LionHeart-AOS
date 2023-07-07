package com.lionheart.domain.repository

import com.lionheart.domain.entity.Lion

interface LionRepository {
    suspend fun getArticleList(week: Int): Result<Lion>
    suspend fun getArticleDetail(articleId: Int): Result<Lion>
}
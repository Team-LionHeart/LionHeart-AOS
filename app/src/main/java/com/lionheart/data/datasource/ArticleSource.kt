package com.lionheart.data.datasource

import com.lionheart.data.service.ArticleService
import com.lionheart.domain.entity.ArticleCategory
import javax.inject.Inject

class ArticleSource @Inject constructor(
    private val articleService: ArticleService,
) {
    suspend fun getCategoryArticle(category: ArticleCategory) =
        articleService.getArticles(category)
}

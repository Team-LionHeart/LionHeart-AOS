package com.lionheart.data.repository

import com.lionheart.data.datasource.ArticleSource
import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.ArticleCategory
import com.lionheart.domain.entity.ArticleDetail
import com.lionheart.domain.entity.TodayArticle
import com.lionheart.domain.entity.WeeklyCourse
import com.lionheart.domain.repository.ArticleRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ArticleRepositoryImpl @Inject constructor(
    private val articleSource: ArticleSource,
) : ArticleRepository {
    override suspend fun getArticleByCategory(category: ArticleCategory): Flow<List<Article>> =
        flow {
            articleSource.getCategoryArticle(category).data?.categoryArticles?.map { article ->
                article.toArticleEntity()
            }?.let {
                emit(
                    it,
                )
            }
        }

    override suspend fun getArticleDetail(articleId: Long): ArticleDetail {
        TODO("Not yet implemented")
    }

    override suspend fun getTodayArticle(): TodayArticle {
        TODO("Not yet implemented")
    }

    override suspend fun getWeeklyArticle(week: Long): WeeklyCourse {
        TODO("Not yet implemented")
    }

    override suspend fun switchBookmark(articleId: Long, switching: Boolean): String =
        articleSource.switchBookmark(articleId, switching).data.toString()

    override suspend fun getBookmarks() {
        TODO("Not yet implemented")
    }
}

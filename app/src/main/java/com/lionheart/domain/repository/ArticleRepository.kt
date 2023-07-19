package com.lionheart.domain.repository

import com.lionheart.domain.entity.Article
import com.lionheart.domain.entity.ArticleCategory
import com.lionheart.domain.entity.ArticleDetail
import com.lionheart.domain.entity.TodayArticle
import com.lionheart.domain.entity.WeeklyCourse
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    /**
     * 카테고리 별 아티클 조회
     */
    suspend fun getArticleByCategory(category: ArticleCategory): Flow<List<Article>>

    /**
     * 아티클 디테일 조회
     */
    suspend fun getArticleDetail(articleId: Long): ArticleDetail

    /**
     * 투데이 아티클 조회
     */
    suspend fun getTodayArticle(): TodayArticle

    /**
     * 주차별 아티클 조회
     */
    suspend fun getWeeklyArticle(week: Long): WeeklyCourse

    /**
     * 북마크 스위칭
     */
    suspend fun switchBookmark(articleId: Long, switching: Boolean): Boolean

    /**
     * TODO : 리턴 값에 북마크 조회 작업 branch 의 dto 적용
     * 북마크 아티클 조회
     */
    suspend fun getBookmarks()
}

package com.lionheart.data.service

import com.lionheart.data.model.request.BookMarkRequest
import com.lionheart.data.model.response.ArticleDetailResponse
import com.lionheart.data.model.response.ArticleListResponse
import com.lionheart.data.model.response.BaseResponse
import com.lionheart.data.model.response.BookMarkListResponse
import com.lionheart.data.model.response.TodayArticleResponse
import com.lionheart.data.model.response.WeeklyArticleResponse
import com.lionheart.domain.entity.ArticleCategory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ArticleService {
    @GET("/api/v1/article")
    suspend fun getArticles(
        @Query("category") category: ArticleCategory,
    ): BaseResponse<ArticleListResponse>

    @GET("/api/v1/article/{articleId}")
    suspend fun getArticleDetail(
        @Path("articleId") articleId: String,
    ): BaseResponse<ArticleDetailResponse>

    @GET("/api/v1/article/today")
    suspend fun getTodayArticle(): BaseResponse<TodayArticleResponse>

    @GET("/api/v1/article/week/{week}")
    suspend fun getWeeklyArticle(): BaseResponse<WeeklyArticleResponse>

    @GET("/api/v1/article/bookmarks")
    suspend fun getBookmarks(): BaseResponse<BookMarkListResponse>

    @POST("/api/v1/article/bookmark")
    suspend fun switchBookmark(
        @Body bookMarkRequest: BookMarkRequest
    ): BaseResponse<Unit>
}
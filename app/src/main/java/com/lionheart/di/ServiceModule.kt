package com.lionheart.di

import com.lionheart.data.service.ArticleService
import com.lionheart.data.service.AuthService
import com.lionheart.data.service.ChallengeService
import com.lionheart.data.service.CurriculumService
import com.lionheart.data.service.MemberService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun articleService(retrofit: Retrofit): ArticleService =
        retrofit.create(ArticleService::class.java)

    @Provides
    @Singleton
    fun authService(retrofit: Retrofit): AuthService =
        retrofit.create(AuthService::class.java)

    @Provides
    @Singleton
    fun challengeService(retrofit: Retrofit): ChallengeService =
        retrofit.create(ChallengeService::class.java)

    @Provides
    @Singleton
    fun curriculumService(retrofit: Retrofit): CurriculumService =
        retrofit.create(CurriculumService::class.java)

    @Provides
    @Singleton
    fun memberService(retrofit: Retrofit): MemberService =
        retrofit.create(MemberService::class.java)
}

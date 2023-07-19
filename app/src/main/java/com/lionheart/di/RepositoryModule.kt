package com.lionheart.di

import com.lionheart.data.repository.ArticleRepositoryImpl
import com.lionheart.data.repository.AuthRepositoryImpl
import com.lionheart.data.repository.ChallengeRepositoryImpl
import com.lionheart.data.repository.CourseRepositoryImpl
import com.lionheart.data.repository.CurriculumRepositoryImpl
import com.lionheart.domain.repository.ArticleRepository
import com.lionheart.domain.repository.AuthRepository
import com.lionheart.domain.repository.ChallengeRepository
import com.lionheart.domain.repository.CourseRepository
import com.lionheart.domain.repository.CurriculumRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {
    @Binds
    @Singleton
    abstract fun articleRepository(
        articleRepositoryImpl: ArticleRepositoryImpl,
    ): ArticleRepository

    @Binds
    @Singleton
    abstract fun authRepository(
        authRepositoryImpl: AuthRepositoryImpl,
    ): AuthRepository

    @Binds
    @Singleton
    abstract fun challengeRepository(
        challengeRepositoryImpl: ChallengeRepositoryImpl,
    ): ChallengeRepository

    @Binds
    @Singleton
    abstract fun courseRepository(
        courseRepositoryImpl: CourseRepositoryImpl,
    ): CourseRepository

    @Binds
    @Singleton
    abstract fun curriculumRepository(
        curriculumRepositoryImpl: CurriculumRepositoryImpl,
    ): CurriculumRepository
}

package com.lionheart.di

import com.lionheart.domain.repository.LionRepository
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
    abstract fun lionRepository(
        lionRepositoryImpl: LionRepositoryImpl,
    ): LionRepository
}

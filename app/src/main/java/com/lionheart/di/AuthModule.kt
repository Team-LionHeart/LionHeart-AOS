package com.lionheart.di

import android.content.Context
import com.lionheart.data.repository.DataStoreRepositoryImpl
import com.lionheart.domain.repository.DataStoreRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AuthModule {
    @Provides
    @Singleton
    fun authRepository(
        @ApplicationContext context: Context
    ): DataStoreRepository = DataStoreRepositoryImpl(context)
}
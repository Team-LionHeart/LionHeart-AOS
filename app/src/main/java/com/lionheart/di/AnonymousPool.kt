package com.lionheart.di

import com.lionheart.data.datasource.AuthDataSource
import com.lionheart.data.repository.AnonymousRepositoryImpl
import com.lionheart.data.repository.FcmRepositoryImpl
import com.lionheart.data.service.AuthService
import com.lionheart.domain.repository.AnonymousRepository
import com.lionheart.domain.repository.FcmRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object AnonymousPool {
    @Provides
    @ViewModelScoped
    fun anonymousRepository(
        networkModule: NetworkModule
    ): AnonymousRepository = AnonymousRepositoryImpl(
        AuthDataSource(
            networkModule.apiServerRetrofitForAnonymous.create(AuthService::class.java)
        )
    )

    @Provides
    @ViewModelScoped
    fun fcmRepository(): FcmRepository = FcmRepositoryImpl()
}
package com.lionheart.di

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.lionheart.BuildConfig.BASE_URL
import com.lionheart.BuildConfig.LION_HEART_LOGIN_TOKEN
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.Interceptor
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val APPLICATION_JSON = "application/json"

    @Provides
    @Singleton
    fun providesInterceptor(): Interceptor =
        Interceptor { chain ->
            with(chain) {
                proceed(
                    request()
                        .newBuilder()
                        // Header 추가
                        .header("Authorization", "Bearer $LION_HEART_LOGIN_TOKEN")
                        .build(),
                )
            }
        }

    @Provides
    @Singleton
    fun providesOkHttpClient(
        interceptor: Interceptor,
    ): OkHttpClient =
        OkHttpClient.Builder()
            .connectTimeout(15, TimeUnit.SECONDS)
            .writeTimeout(20, TimeUnit.SECONDS)
            .readTimeout(15, TimeUnit.SECONDS)
            .addInterceptor(interceptor)
            .addInterceptor(
                HttpLoggingInterceptor().apply {
                    level = HttpLoggingInterceptor.Level.BODY
                },
            )
            .build()

    @Provides
    @Singleton
    fun providesExampleRetrofit(
        client: OkHttpClient,
    ): Retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(
                Json.asConverterFactory(
                    APPLICATION_JSON.toMediaType(),
                ),
            )
            .client(client)
            .build()
}

package com.lionheart.data.repository

import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import com.lionheart.data.LionDataStore
import com.lionheart.data.LionDataStore.dataStore
import com.lionheart.domain.entity.Authentication
import com.lionheart.domain.repository.DataStoreRepository
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map
import timber.log.Timber
import javax.inject.Inject

class DataStoreRepositoryImpl @Inject constructor(
    private val context: Context
) : DataStoreRepository {
    /**
     * LocalStorage 로 부터 Authentication 추출
     * 없을 경우, null 응답
     * (already cached on DataStore Layer)
     */
    override suspend fun getAuthentication(): Authentication? {
        return context.dataStore.data
            .catch { e: Throwable ->
                Timber.tag("dataStore_auth")
                    .e("로컬스토리지(dataStore) 에 접근해 Authentication 정보를 가져오는 도중 오류가 발생했습니다.")
                emit(emptyPreferences())
            }
            .map { preferences: Preferences ->
                preferences[LionDataStore.API_ACCESS_TOKEN]?.let {
                    Authentication(
                        accessToken = it,
                        refreshToken = preferences[LionDataStore.API_REFRESH_TOKEN] ?: ""
                    )
                }
            }.firstOrNull()
    }

    override suspend fun setAuthentication(authentication: Authentication) {
        context.dataStore.edit { mutablePreferences: MutablePreferences ->
            mutablePreferences[LionDataStore.API_ACCESS_TOKEN] =
                requireNotNull(authentication.accessToken) { "NPE when register authentication with accessToken" }
            mutablePreferences[LionDataStore.API_REFRESH_TOKEN] =
                requireNotNull(authentication.accessToken) { "NPE when register authentication with refreshToken" }
        }
    }
}
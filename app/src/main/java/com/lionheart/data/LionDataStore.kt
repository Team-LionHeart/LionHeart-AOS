package com.lionheart.data

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore

object LionDataStore {
    val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "storage")

    val API_ACCESS_TOKEN = stringPreferencesKey("api_access_token")
    val API_REFRESH_TOKEN = stringPreferencesKey("api_refresh_token")
}
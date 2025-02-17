package com.example.newsapplication.data.manager

import android.app.Application
import android.content.Context
import androidx.datastore.preferences.core.MutablePreferences
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.newsapplication.domain.managers.LocalUserManager
import com.example.newsapplication.utils.Constants
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocalUserManagerImpl @Inject constructor(
    private val application: Application
) : LocalUserManager {
    override suspend fun saveAppEntry() {
        application.dataStore.edit { mutablePreferences: MutablePreferences ->
            mutablePreferences[PreferenceKeys.APP_ENTRY_KEY] = true
        }
    }

    override fun readAppEntry(): Flow<Boolean> {
        return application.dataStore.data.map { preferences: Preferences ->
            preferences[PreferenceKeys.APP_ENTRY_KEY] ?: false
        }
    }

}

private val Context.dataStore by preferencesDataStore(Constants.USER_SETTINGS)

private object PreferenceKeys {
    val APP_ENTRY_KEY = booleanPreferencesKey(Constants.APP_ENTRY)
}
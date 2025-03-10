package com.example.newsapplication.domain.usecases.app_entry

import com.example.newsapplication.domain.managers.LocalUserManager
import javax.inject.Inject

class SaveAppEntryUseCase @Inject constructor(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
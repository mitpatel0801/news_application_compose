package com.example.newsapplication.domain.usecases

import com.example.newsapplication.domain.managers.LocalUserManager
import javax.inject.Inject

class SaveAppEntry @Inject constructor(private val localUserManager: LocalUserManager) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}
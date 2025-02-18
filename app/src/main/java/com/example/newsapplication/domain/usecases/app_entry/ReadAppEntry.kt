package com.example.newsapplication.domain.usecases.app_entry

import com.example.newsapplication.domain.managers.LocalUserManager
import javax.inject.Inject

class ReadAppEntry @Inject constructor(private val localUserManager: LocalUserManager) {
    operator fun invoke() = localUserManager.readAppEntry()
}
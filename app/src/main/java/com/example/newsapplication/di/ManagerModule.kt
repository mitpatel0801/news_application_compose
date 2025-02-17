package com.example.newsapplication.di

import com.example.newsapplication.data.manager.LocalUserManagerImpl
import com.example.newsapplication.domain.managers.LocalUserManager
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ManagerModule {

    @Binds
    @Singleton
    abstract fun provideLocalUserManager(
        localUserManager: LocalUserManagerImpl
    ): LocalUserManager

}
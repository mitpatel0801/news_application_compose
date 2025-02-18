package com.example.newsapplication.presentation.onborarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.app_entry.SaveAppEntryUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val saveAppEntryUseCase: SaveAppEntryUseCase) :
    ViewModel() {

    fun setSaveAppEntry() {
        viewModelScope.launch {
            saveAppEntryUseCase()
        }
    }

}
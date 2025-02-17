package com.example.newsapplication.presentation.onborarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnboardingViewModel @Inject constructor(private val saveAppEntry: SaveAppEntry) :
    ViewModel() {

    fun setSaveAppEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }

}
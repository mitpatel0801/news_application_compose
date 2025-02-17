package com.example.newsapplication.presentation.activity

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.ReadAppEntry
import com.example.newsapplication.domain.usecases.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val saveAppEntry: SaveAppEntry,
    private val readAppEntry: ReadAppEntry
) : ViewModel() {

    fun setSaveAppEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }
}
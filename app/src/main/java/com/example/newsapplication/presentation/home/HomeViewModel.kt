package com.example.newsapplication.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.newsapplication.domain.usecases.news.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val getNewsUseCase: GetNewsUseCase) : ViewModel() {

    val news =
        getNewsUseCase(
            listOf(
                "bbc-news",
                "abc-news",
                "al-jazeera-english"
            )
        ).cachedIn(viewModelScope)

}
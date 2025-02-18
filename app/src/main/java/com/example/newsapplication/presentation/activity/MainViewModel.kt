package com.example.newsapplication.presentation.activity

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsapplication.domain.usecases.app_entry.ReadAppEntry
import com.example.newsapplication.presentation.main_nav_graph.Route
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val readAppEntry: ReadAppEntry
) : ViewModel() {

    var startDestination: String? by mutableStateOf(null)
        private set

    init {
        viewModelScope.launch {
            readAppEntry().collect { isOnboarded ->
                startDestination = if (isOnboarded) {
                    Route.BottomNavigationGraph.route
                } else {
                    Route.OnboardingScreen.route
                }
            }
        }
    }
}
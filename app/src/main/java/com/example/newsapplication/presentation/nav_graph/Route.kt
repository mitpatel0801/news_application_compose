package com.example.newsapplication.presentation.nav_graph

sealed class Route(val route: String) {
    data object OnboardingScreen : Route("onboarding")
    data object HomeScreen : Route("home")
    data object BottomNavigationGraph : Route("bottom_nav_bar")
}
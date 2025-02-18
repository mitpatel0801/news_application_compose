package com.example.newsapplication.presentation.nav_graph

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.newsapplication.presentation.onborarding.OnboardingScreen

@Composable
fun MainNavGraph(startDestination: String) {
    Log.d("PersonalLog", "MainNavGraph: $startDestination")
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination) {

        composable(Route.OnboardingScreen.route) {
            OnboardingScreen {
                navController.navigate(Route.BottomNavigationGraph.route)
            }
        }


        composable(
            route = Route.BottomNavigationGraph.route
        ) {
            BottomNavigationGraph()
        }

    }

}
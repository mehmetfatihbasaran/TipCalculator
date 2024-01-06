package com.example.tipcalculator.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tipcalculator.screens.DetailsScreen
import com.example.tipcalculator.screens.HomeScreen

@Composable
fun MovieNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = MovieScreens.HomeScreen.name
    ) {
        composable(MovieScreens.HomeScreen.name) {
            HomeScreen(navController = navController)
        }
        composable(MovieScreens.DetailsScreen.name+"/{movie}",
            arguments = listOf(
                navArgument(name = "movie") {
                    type = NavType.StringType
                }
            )
        ) {backStackEntry ->
            val movie = backStackEntry.arguments?.getString("movie")
            movie?.let {
                DetailsScreen(navController = navController, movieId = it)
            }
        }
    }
}
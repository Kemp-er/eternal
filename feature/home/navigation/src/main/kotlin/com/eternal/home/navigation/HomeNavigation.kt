package com.eternal.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.eternal.home.presentation.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
object HomeGraph

fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph>(startDestination = Home) {
        composable<Home> {
            HomeScreen(
                onNavigateToNewsList = {}
            )
        }
    }
}

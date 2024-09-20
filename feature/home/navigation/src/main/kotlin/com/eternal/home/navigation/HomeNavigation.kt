package com.eternal.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.eternal.home.presentation.HomeScreen
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
object HomeGraph

fun NavGraphBuilder.homeGraph() {
    navigation<HomeGraph>(startDestination = HomeRoute) {
        composable<HomeRoute> {
            HomeScreen()
        }
    }
}

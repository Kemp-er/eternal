package com.eternal.news.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import androidx.navigation.toRoute
import com.eternal.core.presentation.list.NewsListScreen
import com.eternal.core.presentation.list.NewsScreen
import kotlinx.serialization.Serializable

@Serializable
object NewsList

@Serializable
data class News(val id: String)

private const val BASE_ROUTE = "https://eternal.com"

@Serializable
object NewsGraph

fun NavGraphBuilder.newsGraph() {
    navigation<NewsGraph>(startDestination = NewsList) {
        composable<NewsList>(
            deepLinks = listOf(
                navDeepLink<NewsList>(basePath = "$BASE_ROUTE/newslist")
            )
        ) {
            NewsListScreen()
        }

        composable<News>(
            deepLinks = listOf(
                navDeepLink<News>(basePath = "$BASE_ROUTE/news")
            )
        ) { backStackEntry ->
            NewsScreen(id = backStackEntry.toRoute<News>().id)
        }
    }
}

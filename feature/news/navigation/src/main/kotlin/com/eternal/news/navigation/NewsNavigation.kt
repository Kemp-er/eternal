package com.eternal.news.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.eternal.core.presentation.list.NewsListRoute
import com.eternal.core.presentation.list.NewsListScreen
import com.eternal.core.presentation.list.NewsRoute
import com.eternal.core.presentation.list.NewsScreen
import kotlinx.serialization.Serializable

private const val BASE_ROUTE = "https://eternal.com"

@Serializable
object NewsGraph

fun NavController.navigateToNews(id: String, navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = NewsRoute(id)) {
        navOptions()
    }

fun NavGraphBuilder.newsGraph(
    onNewsClick: (String) -> Unit,
    onNewsDetailClick: (String) -> Unit,
) {
    navigation<NewsGraph>(startDestination = NewsListRoute) {
        composable<NewsListRoute>(
            deepLinks = listOf(
                navDeepLink<NewsListRoute>(basePath = "$BASE_ROUTE/news"),
            ),
        ) {
            NewsListScreen(
                onNewsClick = onNewsClick,
            )
        }

        composable<NewsRoute>(
            deepLinks = listOf(
                navDeepLink<NewsRoute>(basePath = "$BASE_ROUTE/news"),
            ),
        ) {
            NewsScreen(
                onNewsDetailClick = onNewsDetailClick,
            )
        }
    }
}

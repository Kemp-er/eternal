package com.ecardero.eternal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.ecardero.eternal.ui.theme.EternalTheme
import com.eternal.home.navigation.HomeGraph
import com.eternal.home.navigation.homeGraph
import com.eternal.news.navigation.NewsGraph
import com.eternal.news.navigation.navigateToNews
import com.eternal.news.navigation.newsGraph
import com.eternal.product.navigation.ProductGraph
import com.eternal.product.navigation.navigateToProduct
import com.eternal.product.navigation.productGraph
import com.orhanobut.logger.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            EternalTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        MainBottomNavigation(
                            navController = navController,
                        )
                    },
                ) { innerPadding ->
                    EternalNavHost(
                        modifier = Modifier.padding(innerPadding),
                        navController = navController,
                    )
                }
            }
        }
    }
}

@Composable
fun EternalNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    //
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = HomeGraph,
    ) {
        homeGraph()
        newsGraph(
            onNewsClick = navController::navigateToNews,
            onNewsDetailClick = navController::navigateToProduct,
        )
        productGraph(
            onProductClick = navController::navigateToProduct,
            onProductDetailClick = navController::navigateToNews,
        )
    }
}

sealed class BottomScreens<T>(val name: String, val route: T) {
    data object Home : BottomScreens<HomeGraph>(name = "Home", route = HomeGraph)
    data object News : BottomScreens<NewsGraph>(name = "News", route = NewsGraph)
    data object Product : BottomScreens<ProductGraph>(name = "Product", route = ProductGraph)
}

@Composable
internal fun MainBottomNavigation(
    modifier: Modifier = Modifier,
    navController: NavController,
) {
    val bottomScreens = remember {
        listOf(
            BottomScreens.Home,
            BottomScreens.News,
            BottomScreens.Product,
        )
    }

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    Logger.d("MainBottomNavigation $currentDestination")

    NavigationBar(
        containerColor = Color.Green,
        modifier = modifier,
    ) {
        bottomScreens.forEach { destination ->
            NavigationBarItem(
                icon = { Icon(Icons.Filled.Favorite, contentDescription = "lol") },
                label = { Text(destination.name) },
                selected = currentDestination?.hierarchy?.any {
                    it.hasRoute(destination.route::class)
                } == true,
                onClick = {
                    // if in the same graph, pop to the start destination
                    val first = currentDestination?.hierarchy?.firstOrNull()
                    Logger.d("First hierarchy destination ${first?.route}")
                    if (currentDestination?.hierarchy?.any { it.hasRoute(destination.route::class) } == true) {
                        navController.popBackStack(navController.graph.findStartDestination().id, false)
                    }

                    navController.navigateToGraph(destination.route)
                },
            )
        }
    }
}

fun <T : Any> NavController.navigateToGraph(route: T) {
    val navOptions = navOptions {
        popUpTo(graph.findStartDestination().id) {
            saveState = true
        }
        launchSingleTop = true
        restoreState = true
    }
    navigate(route = route, navOptions)
}

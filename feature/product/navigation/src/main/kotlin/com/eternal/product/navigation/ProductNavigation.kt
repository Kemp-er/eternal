package com.eternal.product.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptionsBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navDeepLink
import androidx.navigation.navigation
import com.eternal.feature.product.presentation.detail.ProductRoute
import com.eternal.feature.product.presentation.detail.ProductScreen
import com.eternal.feature.product.presentation.list.ProductListRoute
import com.eternal.feature.product.presentation.list.ProductListScreen
import kotlinx.serialization.Serializable

private const val BASE_ROUTE = "https://eternal.com"

@Serializable
object ProductGraph

fun NavController.navigateToProduct(id: String, navOptions: NavOptionsBuilder.() -> Unit = {}) =
    navigate(route = ProductRoute(id)) {
        navOptions()
    }

fun NavGraphBuilder.productGraph(
    onProductClick: (String) -> Unit,
    onProductDetailClick: (String) -> Unit,
) {
    navigation<ProductGraph>(startDestination = ProductListRoute) {
        composable<ProductListRoute>(
            deepLinks = listOf(
                navDeepLink<ProductListRoute>(basePath = "$BASE_ROUTE/product"),
            ),
        ) {
            ProductListScreen(
                onProductClick = onProductClick,
            )
        }

        composable<ProductRoute>(
            deepLinks = listOf(
                navDeepLink<ProductRoute>(basePath = "$BASE_ROUTE/product"),
            ),
        ) {
            ProductScreen(
                onProductClick = onProductDetailClick,
            )
        }
    }
}

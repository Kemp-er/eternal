package com.eternal.feature.product.presentation.detail

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable

@Serializable
data class ProductRoute(val id: String)

@Composable
fun ProductScreen(
    viewModel: ProductDetailViewModel = hiltViewModel(),
    onProductClick: (String) -> Unit,
) {
    val id = viewModel.productId
    val veryLongString: String = "Product ID -> "

    Box(
        modifier = Modifier
            .clickable { onProductClick(id) }
            .fillMaxSize(),
    ) {
        Text(text = veryLongString + id)
    }
}

@Preview(showBackground = true)
@Composable
fun ProductScreenPreview() {
    ProductScreen(onProductClick = {})
}

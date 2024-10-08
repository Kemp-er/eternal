package com.eternal.core.presentation.list

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
data class NewsRoute(val id: String)

@Composable
fun NewsScreen(
    viewModel: NewsDetailViewModel = hiltViewModel(),
    onNewsDetailClick: (String) -> Unit,
) {
    val id = viewModel.newsRouteId
    val veryLongString: String = "News ID -> "

    Box(
        modifier = Modifier
            .clickable { onNewsDetailClick(id) }
            .fillMaxSize(),
    ) {
        Text(text = veryLongString + id)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen(
        onNewsDetailClick = { },
    )
}

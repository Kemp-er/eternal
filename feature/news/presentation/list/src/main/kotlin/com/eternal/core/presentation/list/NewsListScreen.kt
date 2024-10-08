package com.eternal.core.presentation.list

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import kotlinx.serialization.Serializable

@Serializable
object NewsListRoute

@Composable
fun NewsListScreen(
    viewModel: NewsListViewModel = hiltViewModel(),
    onNewsClick: (String) -> Unit = {},
) {
    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyColumn {
            items(1000) { id ->
                Text(
                    modifier = Modifier
                        .clickable { onNewsClick(id.toString()) }
                        .fillMaxWidth(),
                    text = "News $id",
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsListScreenPreview() {
    NewsListScreen()
}

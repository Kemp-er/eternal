package com.eternal.core.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsListScreen() {
    val numberList = (1..1000).toList()

    Box(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        LazyColumn {

        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsListScreenPreview() {
    NewsListScreen()
}

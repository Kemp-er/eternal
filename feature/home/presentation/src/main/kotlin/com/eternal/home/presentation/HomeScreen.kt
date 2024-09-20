package com.eternal.home.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun HomeScreen(
    onNavigateToNewsClick: () -> Unit = {},
) {
    val veryLongString: String = "Hello Home Screen"

    Column(
        modifier = Modifier
            .fillMaxSize(),
    ) {
        Text(
            text = veryLongString,
        )

        Button(
            onClick = onNavigateToNewsClick,
        ) {
            Row {
                Text(text = "Navigate to NewsList")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}

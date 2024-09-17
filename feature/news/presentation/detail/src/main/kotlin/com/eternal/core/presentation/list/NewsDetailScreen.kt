package com.eternal.core.presentation.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsScreen(id: String) {
    val veryLongString: String = "This is a veeeeeeeeeery veeeeeeeeeery very long string that will surpass the " +
        "column threshold most probably"

    Box(
        modifier = Modifier
            .size(100.dp),
    ) {
        Text(text = veryLongString)
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen(
        id = "123"
    )
}

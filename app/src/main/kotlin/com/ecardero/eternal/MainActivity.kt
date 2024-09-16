package com.ecardero.eternal

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.ecardero.eternal.ui.theme.EternalTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EternalTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(
    modifier: Modifier = Modifier,
) {
    val list = (0..1000).toList()
    LazyColumn (
        modifier = modifier
            .fillMaxWidth(),
    ) {
        item {
            TestItem()
        }
        items(list) { item ->
            Text("Hello Uganda $item")
        }
    }
}

@Composable
fun TestItem() {

    val viewModel: MainViewModel = hiltViewModel()
    Text(
        text = "random -> ${viewModel.getTime()}",
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EternalTheme {
        Greeting()
    }
}

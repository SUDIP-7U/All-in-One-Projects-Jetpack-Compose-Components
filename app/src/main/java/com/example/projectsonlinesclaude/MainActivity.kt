package com.example.projectsonlinesclaude

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.projectsonlinesclaude.ui.screens.ItemCard
import com.example.projectsonlinesclaude.ui.screens.JetpackComponentsDemo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            // Default Material 3 theme — no custom colors, themes, or typography.
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    AppRoot()
                }
            }
        }
    }
}

/**
 * Simple in-app switch between the two screens using local state only
 * (no navigation library involved, to keep things default/minimal).
 */
@Composable
fun AppRoot() {
    var showComponentsDemo by remember { mutableStateOf(false) }

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.padding(8.dp)) {
            Button(onClick = { showComponentsDemo = false }) {
                Text("Image List")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { showComponentsDemo = true }) {
                Text("Components Demo")
            }
        }

        if (showComponentsDemo) {
            JetpackComponentsDemo(modifier = Modifier.weight(1f))
        } else {
            ImageListDemo(modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun ImageListDemo(modifier: Modifier = Modifier) {
    val entries = listOf("First item", "Second item", "Third item")

    LazyColumn(modifier = modifier.fillMaxSize()) {
        items(entries) { title ->
            ItemCard(title = title)
        }
    }
}

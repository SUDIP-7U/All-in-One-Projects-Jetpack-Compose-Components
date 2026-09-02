package com.example.projectsonlinesclaude.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A card-style list item that embeds the reusable [ExampleImage]
 * composable alongside a title, demonstrating composable reuse.
 */
@Composable
fun ItemCard(title: String, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column(modifier = Modifier.padding(8.dp)) {
            ExampleImage()
            Text(
                text = title,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

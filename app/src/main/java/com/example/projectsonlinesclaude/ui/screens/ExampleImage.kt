package com.example.projectsonlinesclaude.ui.screens

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.unit.dp

/**
 * Reusable composable that renders a simple "image" card.
 *
 * The image itself is drawn with Compose's built-in Canvas APIs (a sun
 * and mountains, like a generic photo placeholder) so there is no
 * dependency on a drawable resource or any external image library.
 *
 * This composable does not position itself on screen — it is meant to
 * be embedded inside other composables (see [ItemCard]).
 */
@Composable
fun ExampleImage(modifier: Modifier = Modifier) {
    Card(modifier = modifier.fillMaxWidth()) {
        Canvas(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
        ) {
            // Background
            drawRect(color = Color.LightGray)

            // Sun
            drawCircle(
                color = Color(0xFFFFC107),
                radius = size.minDimension / 8,
                center = Offset(size.width * 0.8f, size.height * 0.25f)
            )

            // Mountains
            val mountains = Path().apply {
                moveTo(0f, size.height)
                lineTo(size.width * 0.3f, size.height * 0.4f)
                lineTo(size.width * 0.55f, size.height * 0.75f)
                lineTo(size.width * 0.75f, size.height * 0.35f)
                lineTo(size.width, size.height)
                close()
            }
            drawPath(path = mountains, color = Color(0xFF616161))
        }
    }
}

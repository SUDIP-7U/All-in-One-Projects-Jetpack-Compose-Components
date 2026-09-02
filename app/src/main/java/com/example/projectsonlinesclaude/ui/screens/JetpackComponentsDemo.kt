package com.example.projectsonlinesclaude.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * A screen that showcases a handful of common Jetpack Compose components
 * (buttons, text field, checkbox, switch, radio buttons, slider, progress
 * indicators) using plain Material 3 defaults — no custom colors, themes,
 * or typography, and no external libraries.
 */
@Composable
fun JetpackComponentsDemo(modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var checked by remember { mutableStateOf(false) }
    var switchOn by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    var sliderValue by remember { mutableFloatStateOf(0.5f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Jetpack Compose Components Demo",
            style = MaterialTheme.typography.titleLarge
        )

        // Buttons
        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            Button(onClick = { /* no-op */ }) { Text("Filled") }
            OutlinedButton(onClick = { /* no-op */ }) { Text("Outlined") }
            TextButton(onClick = { /* no-op */ }) { Text("Text") }
        }

        // Text field
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = { Text("Enter text") },
            modifier = Modifier.fillMaxWidth()
        )

        // Checkbox
        Row(verticalAlignment = Alignment.CenterVertically) {
            Checkbox(checked = checked, onCheckedChange = { checked = it })
            Text("Checkbox")
        }

        // Switch
        Row(verticalAlignment = Alignment.CenterVertically) {
            Switch(checked = switchOn, onCheckedChange = { switchOn = it })
            Text("Switch")
        }

        // Radio buttons
        Column {
            listOf("Option 1", "Option 2", "Option 3").forEach { option ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = selectedOption == option,
                        onClick = { selectedOption = option }
                    )
                    Text(option)
                }
            }
        }

        // Slider
        Text("Slider: ${"%.2f".format(sliderValue)}")
        Slider(value = sliderValue, onValueChange = { sliderValue = it })

        // Progress indicators
        LinearProgressIndicator(modifier = Modifier.fillMaxWidth())
        CircularProgressIndicator()

        // Reuses ItemCard (which itself embeds ExampleImage), showing the
        // same reusable composables carried over into this screen too.
        ItemCard(title = "Reused ItemCard inside the demo")
    }
}

package com.cmdv.reverse_engineering.ui.composables

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.cmdv.reverse_engineering.ui.theme.BTCarTheme

/**
 * Composable screen to be rendered on [com.cmdv.reverse_engineering.ReverseEngineeringActivity]
 */
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BTCarTheme {
        Greeting("Android")
    }
}
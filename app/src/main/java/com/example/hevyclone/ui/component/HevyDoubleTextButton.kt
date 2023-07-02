package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyDoubleTextButton(
    title: String,
    content: String,
    color: Color = Color.White,
    onClick: () -> Unit = {},
) {
    TextButton(onClick) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                title,
                color = MaterialTheme.colorScheme.onBackground,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                content,
                color = color,
                fontWeight = FontWeight.Light,
                style = MaterialTheme.typography.labelLarge,
            )
        }
    }
}

@Preview
@Composable
fun HevyDoubleTextButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevyDoubleTextButton(title = "Duration", content = "9s")

    }
}
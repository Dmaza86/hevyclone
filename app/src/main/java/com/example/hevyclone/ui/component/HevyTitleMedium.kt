package com.example.hevyclone.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun HeavyTitleMedium(
    modifier:Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = MaterialTheme.colorScheme.onPrimary
) {
    Text(
        modifier = modifier,
        text = text,
        fontWeight = fontWeight,
        color = color,
        style = MaterialTheme.typography.titleMedium.copy(MaterialTheme.colorScheme.onSurface)
    )
}

@Preview
@Composable
fun HeavyTitleMediumPreview() {
    HevyCloneTheme (darkTheme = true, dynamicColor = false) {
        HeavyTitleMedium(text = "Routines")
    }
}

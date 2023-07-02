package com.example.hevyclone.ui.component

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HeavyTitleMedium(
    modifier:Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Bold,
    color: Color = MaterialTheme.colorScheme.onBackground
) {
    Text(
        modifier = modifier,
        text = text,
        color = color,
        fontWeight = fontWeight,
        style = MaterialTheme.typography.titleMedium
    )
}

@Preview
@Composable
fun HeavyTitleMediumPreview() {
    HevyCloneTheme (darkTheme = true, dynamicColor = false) {
        HeavyTitleMedium(text = "Routines")
    }
}

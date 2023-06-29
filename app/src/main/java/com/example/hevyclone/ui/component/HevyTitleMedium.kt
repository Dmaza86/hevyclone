package com.example.hevyclone.ui.component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HeavyTitleMedium(
    text: String,
    fontSize: TextUnit = 18.sp,
    fontWeight: FontWeight = FontWeight.Bold
) {
    Text(
        text = text,
        fontWeight = fontWeight,
        fontSize = fontSize
    )
}

@Preview
@Composable
fun HeavyTitleMediumPreview() {
    HevyCloneTheme (darkTheme = true, dynamicColor = false) {
        HeavyTitleMedium(text = "Button")
    }
}

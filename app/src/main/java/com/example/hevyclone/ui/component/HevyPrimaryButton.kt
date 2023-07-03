package com.example.hevyclone.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyPrimaryButton(
    modifier: Modifier = Modifier,
    label: String
) {
    Button(
        modifier = modifier,
        onClick = {},
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(Color.Cyan)
    ) {
        Text(
            text = label,
            color = Color.White
        )
    }
}

@Preview
@Composable
fun HevyPrimaryButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevyPrimaryButton(label = "Start Routine")
    }
}
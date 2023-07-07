package com.example.hevyclone.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevySecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    color: Color = Color.White,
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        shape = RoundedCornerShape(8.dp)
    ) {
            Text(
                text = text,
                color = color,
                overflow = TextOverflow.Ellipsis,
                textAlign = TextAlign.Center,
                maxLines = 1,
                style = MaterialTheme.typography.titleMedium
            )
    }
}


@Preview
@Composable
fun HevySecondaryButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevySecondaryButton(text = "Discard Workout", color = Color.Red)
    }
}

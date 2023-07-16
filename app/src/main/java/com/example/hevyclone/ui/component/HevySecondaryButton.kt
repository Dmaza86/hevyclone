package com.example.hevyclone.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.theme.HevyPreviewTheme

@Composable
fun HevySecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit = {},
    textColor: Color = MaterialTheme.colorScheme.onSecondary
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp)
    ) {
        Text(
            text = text,
            overflow = TextOverflow.Ellipsis,
            textAlign = TextAlign.Center,
            maxLines = 1,
            style = MaterialTheme.typography.titleMedium.copy(color = textColor),

            )
    }
}

@Preview
@Composable
fun HevySecondaryButtonPreview() {
    HevyPreviewTheme {
        HevySecondaryButton(
            text = "Discard Workout",
            textColor = MaterialTheme.colorScheme.onError
        )
    }
}

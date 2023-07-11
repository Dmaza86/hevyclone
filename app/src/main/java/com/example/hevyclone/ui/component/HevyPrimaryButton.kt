package com.example.hevyclone.ui.component

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun HevyPrimaryButton(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit = {},
    color: ButtonColors = ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
    )
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(8.dp),
        colors = color
    ) {
        Text(
            text = label,
            style = MaterialTheme.typography.titleMedium,
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
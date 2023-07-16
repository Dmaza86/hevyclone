package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.theme.HevyPreviewTheme

@Composable
fun HevyBasicTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    color: Color = MaterialTheme.colorScheme.onSurface,
    keyboardOptions: KeyboardOptions
) {
    var text by remember { mutableStateOf("") }
    var isPlaceholderVisible by remember { mutableStateOf(true) }

    Box(modifier = modifier then Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
        if (isPlaceholderVisible) {
            Text(
                text = placeholder,
                style = style,
                color = color,
                modifier = Modifier.fillMaxWidth()
            )
        }
        BasicTextField(
            value = text,
            onValueChange = {
                text = it
                isPlaceholderVisible = it.isEmpty()
            },
            keyboardOptions = keyboardOptions,
            textStyle = style,
            modifier = Modifier.fillMaxWidth()
        )
    }
}

@Preview
@Composable
fun HevyBasicTextFieldPreview() {
    HevyPreviewTheme{
        HevyBasicTextField(
            placeholder = "Add notes here...",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
    }
}

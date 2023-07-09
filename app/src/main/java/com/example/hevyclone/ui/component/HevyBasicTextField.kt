package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyBasicTextField(
    placeholder: String,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    color: Color = MaterialTheme.colorScheme.onSurface,
    keyboardOptions: KeyboardOptions
) {
    var text by remember { mutableStateOf("") }
    var isPlaceholderVisible by remember { mutableStateOf(true) }

    Column() {
        if (isPlaceholderVisible) {
            Text(
                text = placeholder,
                style = style,
                color = color,
                modifier = Modifier.padding(start = 16.dp, top = 16.dp)
            )
        }
    }
    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            isPlaceholderVisible = it.isEmpty()
        },
        keyboardOptions = keyboardOptions,
        textStyle = style,
        modifier = Modifier
            .heightIn(Dp.Infinity)
            .width(IntrinsicSize.Min)
            .padding(start = 16.dp),
    )
}

@Preview
@Composable
fun HevyBasicTextFieldPreview() {
    HevyCloneTheme(darkTheme = true) {
        HevyBasicTextField(
            placeholder = "Add notes here...",
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
    }
}

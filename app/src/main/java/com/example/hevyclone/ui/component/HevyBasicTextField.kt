package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.LocalTextStyle
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun HevyBasicTextField(
    modifier: Modifier = Modifier,
    placeholder: String,
    style: TextStyle = MaterialTheme.typography.titleLarge,
    align: TextAlign = TextAlign.Center,
    color: Color = MaterialTheme.colorScheme.onSurface,
    keyboardOptions: KeyboardOptions
) {
    var text by remember { mutableStateOf("") }
    var isPlaceholderVisible by remember { mutableStateOf(true) }

    BasicTextField(
        value = text,
        onValueChange = {
            text = it
            isPlaceholderVisible = it.isEmpty()
        },
        keyboardOptions = keyboardOptions,
        textStyle = LocalTextStyle.current.copy(
            textAlign = align,
            fontSize = MaterialTheme.typography.titleLarge.fontSize,
            color = color
        ),
        modifier = Modifier.fillMaxWidth(),
        singleLine = true,
        decorationBox = { innerTextField ->
            Box(
                modifier = modifier then Modifier.fillMaxWidth(),
                contentAlignment = if(align == TextAlign.Center) Alignment.Center else Alignment.TopStart
            ) {
                if (isPlaceholderVisible) {
                    Text(
                        text = placeholder,
                        style = style,
                        color = color,
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = align
                    )
                }
                innerTextField()
            }
        }
    )
}

@Preview
@Composable
fun HevyBasicTextFieldPreview() {
    HevyCloneTheme(darkTheme = true) {
        HevyBasicTextField(
            placeholder = "Add notes here...",
            align = TextAlign.Start,
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
        )
    }
}

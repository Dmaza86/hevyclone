package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SmallFloatingActionButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme


@Composable
fun HevyTable(
    onClick: () -> Unit = {},
    style: TextStyle = MaterialTheme.typography.titleLarge,
    textHeader1: String,
    textHeader2: String,
    textHeader3: String,
    textHeader4: String,
    iconImageVector: ImageVector,
    textColumn1: String,
    textColumn2: String,
    placeholder1: String,
    placeholder2: String,
) {
    Column(
        modifier = Modifier
            .verticalScroll(rememberScrollState())
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Row(
            Modifier
                .padding(8.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HevyHeaderButton(text = textHeader1)
            HevyHeaderButton(text = textHeader2)
            HevyHeaderButton(text = textHeader3)
            HevyHeaderButton(text = textHeader4)
            HevyIconButton(
                iconImageVector = iconImageVector,
                tint = MaterialTheme.colorScheme.onSurface,
                modifier = Modifier.size(24.dp)
            )
        }
        Row(
            Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically

        ) {
            TextButton(onClick) {
                Text(
                    text = textColumn1,
                    color = MaterialTheme.colorScheme.onPrimary,
                    style = style
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                TextButton(onClick) {
                    Text(
                        text = textColumn2,
                        color = MaterialTheme.colorScheme.onSurface,
                        style = style
                    )
                }
            }
            Column {
                HevyBasicTextField(
                    placeholder = placeholder1,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Column {
                HevyBasicTextField(
                    placeholder = placeholder2,
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Column(
                modifier = Modifier.padding(end = 8.dp)
            ) {
                SmallFloatingActionButton(
                    onClick,
                    contentColor = MaterialTheme.colorScheme.onPrimary
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Check,
                        contentDescription = null
                    )
                }
            }
        }
    }
}

@Composable
fun HevyHeaderButton(
    onClick: () -> Unit = {},
    text: String,
    color: Color = Color.Gray,
    style: TextStyle = MaterialTheme.typography.titleMedium
) {
    TextButton(onClick) {
        Text(
            text = text, color = color, style = style
        )
    }
}

@Preview
@Composable
fun HevyTablePreview() {
    HevyCloneTheme(darkTheme = true) {
        HevyTable(
            textHeader1 = "SET",
            textHeader2 = "PREVIOUS",
            textHeader3 = "KG",
            textHeader4 = "REPS",
            iconImageVector = Icons.Outlined.Check,
            textColumn1 = "1",
            textColumn2 = "-",
            placeholder1 = "0",
            placeholder2 = "0"
        )
    }
}

package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme


@Composable
fun HevyTable(onClick: () -> Unit = {}) {
    LazyColumn() {
        item {
            Row(
                Modifier
                    .padding(8.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HevyHeaderButton(text = "SET")
                HevyHeaderButton(text = "PREVIOUS")
                HevyHeaderButton(text = "KG")
                HevyHeaderButton(text = "REPS")
                HevyIconButton(
                    iconImageVector = Icons.Outlined.Check,
                    tint = Color.Gray,
                    modifier = Modifier.size(24.dp)
                )
            }
            Row(
                Modifier
                    .fillMaxWidth()
                    .fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextButton(onClick) {
                    Text(
                        text = "1", color = Color.White, style = MaterialTheme.typography.titleLarge
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    TextButton(onClick) {
                        Text(
                            text = "-",
                            color = Color.White,
                            style = MaterialTheme.typography.titleLarge
                        )
                    }
                }
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    HevyBasicTextField(placeholder = "0",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                    HevyBasicTextField(
                        placeholder = "0",
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                SmallFloatingActionButton(
                    onClick,
                    containerColor = Color.Gray,
                    modifier = Modifier.padding(end = 8.dp)
                ) {
                    Icon(
                        imageVector = Icons.Outlined.Check,
                        contentDescription = null,
                        tint = Color.White
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
        HevyTable()
    }
}

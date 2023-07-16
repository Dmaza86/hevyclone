package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
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
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.theme.HevyPreviewTheme

//
// @Composable
// fun RowScope.HevyCell(
//     modifier: Modifier = Modifier,
//     content: @Composable () -> Unit
// ) {
//     Box(
//         modifier = modifier then Modifier.weight(1f).fillMaxWidth()
//     ){
//         content()
//     }
// }
@Composable
fun HevyTable() {
    LazyColumn(
        modifier = Modifier
            .padding(16.dp)
    ) {
        item {
            Row(
                Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ) {
                HevyHeaderButton(text = "SET")
                HevyHeaderButton(text = "PREVIOUS")
                HevyHeaderButton(text = "KG")
                HevyHeaderButton(text = "REPS")
                HevyIconButton(
                    iconImageVector = Icons.Default.Check,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .weight(1f)
                        .size(24.dp)
                )
            }
        }
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        text = "1",
                        color = MaterialTheme.colorScheme.onPrimary,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                TextButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .padding(4.dp)
                ) {
                    Text(
                        text = "-",
                        color = MaterialTheme.colorScheme.onSurface,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
                HevyBasicTextField(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .padding(4.dp),
                    placeholder = "0",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                HevyBasicTextField(
                    modifier = Modifier
                        .weight(2f)
                        .fillMaxWidth()
                        .padding(4.dp),
                    placeholder = "0",
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
                SmallFloatingActionButton(
                    onClick = {},
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxWidth()
                        .padding(4.dp),
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
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.titleMedium
) {
    TextButton(onClick, modifier = modifier) {
        Text(
            text = text,
            color = color,
            style = style,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis
        )
    }
}

@Preview
@Composable
fun HevyTablePreview() {
    HevyPreviewTheme {
        HevyTable()
    }
}

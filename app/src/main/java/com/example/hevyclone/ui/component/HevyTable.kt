package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.theme.HevyPreviewTheme

@Composable
fun RowScope.TableCell(
    weight: Float = 2f,
    content: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .weight(weight)
            .fillMaxWidth()
            .padding(2.dp),
        contentAlignment = Alignment.Center
    ) {
        content()
    }
}

data class HevySet(
    val setNumber: Int,
    val previous: String,
    val weight: Number,
    val reps: Int,
    val done: Boolean
)

@Composable
fun HevyTable(sets: List<HevySet>) {

    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TableCell(weight = 1f) {
                HevyHeaderButton(text = "SET")
            }
            TableCell {
                HevyHeaderButton(text = "PREVIOUS")
            }
            TableCell {
                HevyHeaderButton(text = "KG")
            }
            TableCell {
                HevyHeaderButton(text = "REPS")
            }
            TableCell(weight = 1f) {
                HevyIconButton(
                    iconImageVector = Icons.Outlined.Check,
                    tint = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier.size(24.dp)
                )
            }
        }
        sets.forEach { set ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically

            ) {
                TableCell(weight = 1f) {
                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = set.setNumber.toString(),
                            textAlign = TextAlign.Center,
                            modifier = Modifier.fillMaxWidth(),
                            color = MaterialTheme.colorScheme.onPrimary,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                TableCell {
                    TextButton(
                        onClick = {},
                        contentPadding = PaddingValues(0.dp)
                    ) {
                        Text(
                            text = set.previous.ifEmpty { "-" },
                            color = MaterialTheme.colorScheme.onSurface,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
                TableCell {
                    HevyBasicTextField(
                        placeholder = "0",
                        initialValue = set.weight.toString(),
                        style = MaterialTheme.typography.titleMedium.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                TableCell {
                    HevyBasicTextField(
                        placeholder = "0",
                        initialValue = set.reps.toString(),
                        style = MaterialTheme.typography.titleLarge.copy(textAlign = TextAlign.Center),
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                    )
                }
                TableCell(weight = 1f) {
                    SmallFloatingActionButton(
                        onClick = {},
                        modifier = Modifier.size(30.dp),
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
}

@Composable
fun HevyHeaderButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    text: String,
    color: Color = MaterialTheme.colorScheme.onSurface,
    style: TextStyle = MaterialTheme.typography.titleMedium
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center,
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
        HevyTable(
            listOf(
                HevySet(
                    setNumber = 1,
                    previous = "",
                    weight = 23,
                    reps = 5,
                    done = false
                ),
                HevySet(
                    setNumber = 2,
                    previous = "133kgx12",
                    weight = 240.3,
                    reps = 23,
                    done = false
                ),
                HevySet(
                    setNumber = 2,
                    previous = "3kgx12",
                    weight = 34.3,
                    reps = 13,
                    done = false
                )
            )
        )

    }
}

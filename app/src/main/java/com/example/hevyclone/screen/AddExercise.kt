@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class
)

package com.example.hevyclone.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.model.Exercise
import com.example.hevyclone.ui.component.HevyIconButton
import com.example.hevyclone.ui.component.HevySecondaryButton
import com.example.hevyclone.ui.component.HevyTitleMedium
import com.example.hevyclone.ui.theme.HevyPreviewTheme


@ExperimentalMaterial3Api
@Composable

fun AddExercise(onNavigateToWorkout: ()->Unit, onAddExercise:(Exercise)-> Unit) {
    var text by remember { mutableStateOf("") }

    val newExercise = Exercise(
        title = "21s Bicep Curl",
        notes = "Biceps",
        sets = listOf()
    )

    Scaffold(topBar = {
        CenterAlignedTopAppBar(
            title = {
                Text(
                    text = "Add Exercise",
                    style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.onPrimary),
                    maxLines = 1
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.DarkGray),
            navigationIcon = {
                TextButton(onClick = onNavigateToWorkout) {
                    Text(
                        text = "Cancel",
                        style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary)
                    )
                }
            },
            actions = {
                TextButton(onClick = { }) {
                    Text(
                        text = "Create",
                        style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.secondary)
                    )
                }
            }
        )

    }) { contentPadding ->
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {

            Row()
            {
                TextField(
                    value = text,
                    onValueChange = { text = it },
                    placeholder = { "Search Exercises" },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Outlined.Search,
                            contentDescription = null
                        )
                    },
                    trailingIcon = {
                        IconButton(
                            onClick = {},
                            modifier = Modifier.shadow(2.dp, shape = CircleShape),
                            colors = IconButtonDefaults.filledIconButtonColors(
                                MaterialTheme.colorScheme.onSurface,
                            )
                        ) {
                            Icon(imageVector = Icons.Filled.Clear, contentDescription = null)
                        }
                    },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                    colors = TextFieldDefaults.textFieldColors(
                        cursorColor = MaterialTheme.colorScheme.secondary,
                        textColor = MaterialTheme.colorScheme.onPrimary,
                        containerColor = MaterialTheme.colorScheme.primary,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent
                    )
                )
            }

            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HevySecondaryButton(
                    Modifier.weight(1f),
                    text = "All Equipment",
                )
                Spacer(modifier = Modifier.width(16.dp))
                HevySecondaryButton(
                    Modifier.weight(1f),
                    text = "All Muscles"
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            LazyColumn {
                item {
                    HevyTitleMedium(text = "All Exercises")
                }
                item {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth(),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.background
                        )
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.SpaceBetween
                        )
                        {
                            Box(modifier = Modifier.weight(1f)) {
                                TextButton(
                                    onClick = {
                                        onAddExercise(newExercise)
                                        onNavigateToWorkout()
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    colors = ButtonDefaults.buttonColors(
                                        containerColor = Color.Transparent,
                                        contentColor = MaterialTheme.colorScheme.secondary
                                    ),
                                    contentPadding = PaddingValues(0.dp)
                                ) {
                                    Row(
                                        modifier = Modifier
                                            .padding(12.dp)
                                            .fillMaxWidth()
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(60.dp),
                                            painter = painterResource(id = R.drawable.clipboard),
                                            contentDescription = null,
                                        )
                                        Spacer(modifier = Modifier.width(8.dp))
                                        Column {
                                            Text(
                                                text = "21s Bicep Curl",
                                                maxLines = 1,
                                                style = MaterialTheme.typography.titleLarge
                                            )
                                            Text(
                                                text = "Biceps",
                                                style = MaterialTheme.typography.titleLarge,
                                                color = MaterialTheme.colorScheme.primary
                                            )
                                        }
                                    }
                                }
                            }
                            HevyIconButton(iconImageVector = Icons.Default.AddCircle)
                        }
                        Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 1.dp)
                    }
                }
            }
        }
    }
}


@Preview
@Composable
fun AddExercisePreview() {
    HevyPreviewTheme {
        AddExercise(onNavigateToWorkout= {}, onAddExercise = {exercise ->  })
    }
}
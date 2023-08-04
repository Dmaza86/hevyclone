@file:OptIn(
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class,
    ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class
)

package com.example.hevyclone.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.arkivanov.decompose.extensions.compose.jetpack.subscribeAsState
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.hevyclone.R
import com.example.hevyclone.component.WorkoutComponent
import com.example.hevyclone.component.WorkoutComponent.Model
import com.example.hevyclone.model.OngoingExercise
import com.example.hevyclone.ui.component.HevyDoubleTextButton
import com.example.hevyclone.ui.component.HevyExerciseCard
import com.example.hevyclone.ui.component.HevyIconButton
import com.example.hevyclone.ui.component.HevyPrimaryButton
import com.example.hevyclone.ui.component.HevySecondaryButton
import com.example.hevyclone.ui.component.HevyTitleMedium
import com.example.hevyclone.ui.theme.HevyPreviewTheme

@ExperimentalMaterial3Api
@Composable
fun WorkoutUi(
    component: WorkoutComponent,
) {
    val model by component.model.subscribeAsState()
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Log Workout",
                style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.onPrimary),
                maxLines = 1
            )
        },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.DarkGray),
            navigationIcon = {
                HevyIconButton(
                    modifier = Modifier.size(350.dp),
                    iconImageVector = Icons.Outlined.KeyboardArrowDown,
                    onClick = component::onBackPressed
                )
            },
            actions = {
                HevyIconButton(
                    modifier = Modifier
                        .size(350.dp)
                        .padding(end = 8.dp),
                    iconDrawableId = R.drawable.timer
                )
                HevyPrimaryButton(label = "Finish")
            })
    }) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            item {
                Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 4.dp)
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = 16.dp),
                    horizontalArrangement = Arrangement.SpaceBetween
                )
                {
                    HevyDoubleTextButton(
                        title = "Duration",
                        content = "9s",
                        color = MaterialTheme.colorScheme.secondary
                    )
                    HevyDoubleTextButton(title = "Volume", content = "0 lbs")
                    HevyDoubleTextButton(title = "Sets", content = "0")
                }
                Divider(color = MaterialTheme.colorScheme.onSurface, thickness = 1.dp)
            }
            item {
                if (model.ongoingExercises.isEmpty()) {
                    EmptyView()
                }
            }
            items(model.ongoingExercises) { exercise ->
                Spacer(modifier = Modifier.height(16.dp))
                HevyExerciseCard(ongoingExercise = exercise, onAddSet = component::onAddSet)
            }

            item {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HevyPrimaryButton(
                        label = "+ Add Exercise",
                        modifier = Modifier.fillMaxWidth(),
                        onClick = component::onAddExercise
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    HevySecondaryButton(
                        modifier = Modifier.weight(1f),
                        text = "Settings",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    HevySecondaryButton(
                        modifier = Modifier.weight(1f),
                        text = "Discard Workout",
                        textColor = MaterialTheme.colorScheme.onError
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyView() {
    Column {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        )
        {
            Icon(
                painter = painterResource(id = R.drawable.dumbbell_horizontal),
                tint = Color.White,
                contentDescription = null,
                modifier = Modifier.size(30.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            HevyTitleMedium(text = "Get started")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Text(
                text = "Add an exercise to start your workout",
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun WorkoutPreview() {
    HevyPreviewTheme {
        WorkoutUi(component = object : WorkoutComponent {
            override val model: Value<Model> = MutableValue(Model())

            override fun onBackPressed() {
                TODO("Not yet implemented")
            }

            override fun onAddExercise() {
                TODO("Not yet implemented")
            }

            override fun onAddSet(ongoingExercise: OngoingExercise) {
                TODO("Not yet implemented")
            }
        })
    }
}

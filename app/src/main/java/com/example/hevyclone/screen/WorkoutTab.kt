package com.example.hevyclone.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.component.HeavyTitleMedium
import com.example.hevyclone.ui.component.HevyIconButton
import com.example.hevyclone.ui.component.HevyIconTitleButton
import com.example.hevyclone.ui.component.HevyRoutinesCard
import com.example.hevyclone.ui.component.HevySecondaryIconButton
import com.example.hevyclone.ui.theme.HevyPreviewTheme

data class Routine(
    val title: String,
    val content: String
)

data class Folder(
    val title: String,
    val routines: List<Routine>
)

fun LazyListScope.workoutTab(
    folders: List<Folder>,
    onNavigateToWorkout: () -> Unit
) {


    item {
        Row {
            HeavyTitleMedium(text = "Quick Start")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row {
            HevySecondaryIconButton(
                modifier = Modifier.fillMaxWidth(),
                text = "Start Empty Workout",
                iconImageVector = Icons.Default.Add,
                onClick = onNavigateToWorkout
            )
            Spacer(modifier = Modifier.height(8.dp))
        }
    }
    item {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HeavyTitleMedium(text = "Routines")
            HevyIconButton(iconDrawableId = R.drawable.new_folder)
        }
        Spacer(modifier = Modifier.height(8.dp))
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            HevySecondaryIconButton(
                modifier = Modifier.weight(1f),
                text = "New Routine",
                iconDrawableId = R.drawable.clipboard
            )
            Spacer(modifier = Modifier.width(8.dp))
            HevySecondaryIconButton(
                modifier = Modifier.weight(1f),
                text = "Explore",
                iconImageVector = Icons.Default.Search
            )
        }
    }
    items(folders) { folder ->
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            HevyIconTitleButton(
                text = folder.title,
                iconImageVector = Icons.Default.ArrowDropDown
            )
            HevyIconButton(
                iconDrawableId = R.drawable.more_horizontal
            )
        }
        if (folder.routines.isEmpty()) {
            Text(text = "there is no routine", color = MaterialTheme.colorScheme.secondary)
        }
        folder.routines.forEach { routine ->
            HevyRoutinesCard(
                title = routine.title,
                text = routine.content,
                label = "Start Routine"
            )
        }
    }
}

@Preview
@Composable
fun WorkoutTabPreview() {
    HevyPreviewTheme {
        LazyColumn {
            workoutTab(
                listOf(
                    Folder(
                        "Phase0", emptyList(
                        )
                    ),
                    Folder(
                        "Phase1", listOf(
                            Routine(
                                "Push",
                                "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback."
                            ),
                            Routine(
                                "Leg",
                                "Calf, Squats"
                            )
                        )
                    ),
                    Folder(
                        "Phase2", listOf(
                            Routine(
                                "Push",
                                "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback."
                            ),
                            Routine(
                                "Leg",
                                "Calf, Squats"
                            )
                        )
                    )
                ), onNavigateToWorkout = {}
            )
        }
    }
}

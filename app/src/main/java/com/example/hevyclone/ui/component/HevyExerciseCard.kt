package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.model.HevySet
import com.example.hevyclone.model.OngoingExercise
import com.example.hevyclone.model.getMockExerciseDisplayed
import com.example.hevyclone.ui.theme.HevyPreviewTheme


@Composable
fun HevyExerciseCard(ongoingExercise: OngoingExercise, onAddSet: (OngoingExercise) -> Unit) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
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
            TextButton(
                onClick = {},
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.secondary
                ),
                contentPadding = PaddingValues(0.dp)
            ) {
                Icon(
                    modifier = Modifier.size(28.dp),
                    painter = painterResource(id = R.drawable.clipboard),
                    contentDescription = null,
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = ongoingExercise.exercise.name,
                    style = MaterialTheme.typography.titleLarge
                )
            }
            HevyIconButton(iconImageVector = Icons.Default.MoreVert)
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            HevyBasicTextField(
                placeholder = "Add notes here...",
                initialValue = ongoingExercise.notes,
                style = MaterialTheme.typography.bodyLarge,
                align = TextAlign.Start,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
        }
        Row(modifier = Modifier.fillMaxWidth()) {
            TextButton(
                onClick = {},
                contentPadding = PaddingValues(0.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color.Transparent,
                    contentColor = MaterialTheme.colorScheme.secondary
                )
            ) {
                Icon(
                    painterResource(id = R.drawable.timer),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = "Rest Timer: OFF",
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }
        HevyTable(sets = ongoingExercise.sets, onAddSet = { onAddSet(ongoingExercise) })
    }
}

@Preview
@Composable
fun HevyExerciseCardPreview() {
    HevyPreviewTheme {
        HevyExerciseCard(
            ongoingExercise = OngoingExercise(
                exercise = getMockExerciseDisplayed().find { it.name == "Front Squat" }!!,
                notes = "",
                sets = listOf(
                    HevySet(
                        setNumber = 1,
                        previous = "5kgx10",
                        weight = 5.4,
                        reps = 8,
                        done = true
                    )
                )
            ),
            onAddSet = {}
        )
    }
}
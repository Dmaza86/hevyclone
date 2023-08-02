@file:OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3Api::class)

package com.example.hevyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.example.hevyclone.model.Exercise
import com.example.hevyclone.model.HevySet
import com.example.hevyclone.model.OngoingExercise
import com.example.hevyclone.model.getMockExerciseDisplayed
import com.example.hevyclone.model.getMockOngoingExercises
import com.example.hevyclone.screen.AddExercise
import com.example.hevyclone.screen.Main
import com.example.hevyclone.screen.Workout
import com.example.hevyclone.ui.theme.HevyPreviewTheme

sealed class Screen {
    object Main : Screen()
    object Workout : Screen()
    object AddExercise : Screen()
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HevyPreviewTheme {
                var currentScreen: Screen by remember { mutableStateOf(Screen.Main) }
                val navigateToWorkout = { currentScreen = Screen.Workout }
                val navigateToMain = { currentScreen = Screen.Main }
                val navigateToAddExercise = { currentScreen = Screen.AddExercise }
                var ongoingExercises: List<OngoingExercise> by remember {
                    mutableStateOf(
                        getMockOngoingExercises()
                    )
                }
                val exercises: List<Exercise> by remember {
                    mutableStateOf(
                        getMockExerciseDisplayed()
                    )
                }
                val onAddSet = { selectedOngoingExercise: OngoingExercise ->
                    val updatedExercise = selectedOngoingExercise.copy(
                        sets = selectedOngoingExercise.sets + HevySet(
                            setNumber = selectedOngoingExercise.sets.size + 1,
                            previous = "-",
                            weight = 0,
                            reps = 0,
                            done = false
                        )
                    )
                    ongoingExercises = ongoingExercises.map { ongoingExercise-> if (ongoingExercise == selectedOngoingExercise) updatedExercise else ongoingExercise }
                }

                when (currentScreen) {
                    is Screen.Main -> Main(onNavigateToWorkout = navigateToWorkout)
                    is Screen.AddExercise -> AddExercise(
                        onNavigateToWorkout = navigateToWorkout,
                        onAddExercise = { newExercise ->
                            ongoingExercises =
                                ongoingExercises + OngoingExercise(
                                    exercise = newExercise,
                                    notes = "",
                                    sets = listOf(
                                        HevySet(
                                            setNumber = 1,
                                            previous = "-",
                                            weight = 0,
                                            reps = 0,
                                            done = false
                                        )
                                    )
                                )
                        },
                        exerciseList = exercises
                    )

                    is Screen.Workout -> Workout(
                        onNavigateToMain = navigateToMain,
                        onNavigateToAddExercise = navigateToAddExercise,
                        ongoingExercises = ongoingExercises,
                        onAddSet = onAddSet
                    )
                }
            }
        }
    }
}

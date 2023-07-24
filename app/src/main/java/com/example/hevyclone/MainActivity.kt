@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

                when (currentScreen) {
                    is Screen.Main -> Main(onNavigateToWorkout = navigateToWorkout)
                    Screen.AddExercise -> AddExercise(onNavigateToMain = navigateToMain)
                    Screen.Workout -> Workout(onNavigateToMain = navigateToMain, onNavigateToAddExercise = navigateToAddExercise)
                }
            }
        }
    }
}

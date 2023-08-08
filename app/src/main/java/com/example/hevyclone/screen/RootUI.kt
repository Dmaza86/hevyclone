package com.example.hevyclone.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.hevyclone.component.RootComponent
import com.example.hevyclone.component.RootComponent.Child

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RootUI(component: RootComponent){
    Children(
        stack = component.stack
    ) {
        when (val child = it.instance) {
            is Child.AddExercise -> AddExerciseUI(child.component)
            is Child.Main -> MainUI(child.component)
            is Child.Workout -> WorkoutUI(child.component)
        }
    }
}
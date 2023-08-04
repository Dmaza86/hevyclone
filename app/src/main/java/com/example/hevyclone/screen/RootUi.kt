@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.arkivanov.decompose.extensions.compose.jetpack.stack.Children
import com.example.hevyclone.component.RootComponent
import com.example.hevyclone.component.RootComponent.Child

@Composable
fun RootUi(component: RootComponent) {
    Children(
        stack = component.stack,
    ) {
        when (val child = it.instance) {
            is Child.AddExercise -> TODO()
            is Child.Main -> MainUi(child.component)
            is Child.Workout -> WorkoutUi(child.component)
        }
    }
}
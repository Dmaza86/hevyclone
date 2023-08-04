package com.example.hevyclone.component

import com.arkivanov.decompose.ComponentContext

interface AddExerciseComponent {
}

class DefaultAddExerciseComponent(componentContext: ComponentContext) : AddExerciseComponent,
    ComponentContext by componentContext
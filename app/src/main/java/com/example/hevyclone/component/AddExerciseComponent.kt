package com.example.hevyclone.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.hevyclone.component.AddExerciseComponent.*
import com.example.hevyclone.model.Exercise
import com.example.hevyclone.model.getMockExerciseDisplayed

interface AddExerciseComponent {
    val model: Value<Model>

    data class Model(
        val exerciseList: List<Exercise> = emptyList()
    )

    fun onBackPressed()
    fun onAddExercise(exercise: Exercise)

    sealed interface Output {
        object BackPressed : Output
        data class ExerciseAdded(val exercise: Exercise): Output
    }
}

class DefaultAddExerciseComponent(
    componentContext: ComponentContext,
    private val onOutput: (Output) -> Unit
) : AddExerciseComponent,
    ComponentContext by componentContext {

    override val model: Value<Model> = MutableValue(
        Model(getMockExerciseDisplayed())
    )

    override fun onBackPressed() {
        onOutput(Output.BackPressed)
    }

    override fun onAddExercise(exercise: Exercise) {
        onOutput(Output.ExerciseAdded(exercise))
    }
}

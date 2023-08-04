package com.example.hevyclone.component

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value
import com.example.hevyclone.component.WorkoutComponent.Output
import com.example.hevyclone.model.OngoingExercise
import com.example.hevyclone.model.getMockOngoingExercises

interface WorkoutComponent {
    val model: Value<Model>

    data class Model(
        val ongoingExercises: List<OngoingExercise> = emptyList(),
    )

    fun onBackPressed()
    fun onAddExercise()
    fun onAddSet(ongoingExercise: OngoingExercise)

    sealed interface Output {
        object BackPressed : Output
    }
}

class DefaultWorkoutComponent(
    componentContext: ComponentContext,
    private val onOutput: (Output) -> Unit,
) : WorkoutComponent,
    ComponentContext by componentContext {
    override val model: Value<WorkoutComponent.Model> =
        MutableValue(WorkoutComponent.Model(getMockOngoingExercises()))

    override fun onBackPressed() {
        onOutput(Output.BackPressed)
    }

    override fun onAddExercise() {
        TODO("Not yet implemented")
    }

    override fun onAddSet(ongoingExercise: OngoingExercise) {
        TODO("Not yet implemented")
    }
}

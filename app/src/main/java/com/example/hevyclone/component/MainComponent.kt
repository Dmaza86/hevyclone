package com.example.hevyclone.component

import com.arkivanov.decompose.ComponentContext
import com.example.hevyclone.component.MainComponent.Output

interface MainComponent {

    fun onWorkoutStarted()
    sealed interface Output {
        object WorkoutStarted : Output
    }

}

class DefaultMainComponent(
    componentContext: ComponentContext,
   private val onOutput: (Output) -> Unit
) : MainComponent,
    ComponentContext by componentContext {
    override fun onWorkoutStarted() {
      onOutput(Output.WorkoutStarted)
    }
}

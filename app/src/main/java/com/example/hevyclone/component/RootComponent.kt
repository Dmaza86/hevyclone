package com.example.hevyclone.component

import android.os.Parcelable
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.router.stack.ChildStack
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.push
import com.arkivanov.decompose.value.Value
import com.example.hevyclone.component.RootComponent.Child
import com.example.hevyclone.model.Exercise
import kotlinx.parcelize.Parcelize

interface RootComponent {
    val stack: Value<ChildStack<*, Child>>

    sealed class Child {
        data class Main(val component: MainComponent) : Child()
        data class Workout(val component: WorkoutComponent) : Child()
        data class AddExercise(val component: AddExerciseComponent) : Child()
    }
}

class DefaultRootComponent(
    componentContext: ComponentContext,
) : RootComponent, ComponentContext by componentContext {
    private val navigation = StackNavigation<Config>()

    override val stack: Value<ChildStack<*, Child>> =
        childStack(
            source = navigation,
            initialConfiguration = Config.Main,
            handleBackButton = true,
            childFactory = ::child,
        )

    private fun child(config: Config, componentContext: ComponentContext): Child =
        when (config) {
            is Config.AddExercise -> Child.AddExercise(createAddExerciseComponent(componentContext))
            is Config.Main -> Child.Main(createMainComponent(componentContext))
            is Config.Workout -> Child.Workout(createWorkoutComponent(componentContext))
            is Config.WorkoutWithNewExercise -> Child.Workout(createWorkoutComponent(componentContext))
        }

    private fun createAddExerciseComponent(componentContext: ComponentContext): AddExerciseComponent =
        DefaultAddExerciseComponent(
            componentContext = componentContext,
            onOutput = ::onAddExerciseOutput
        )

    private fun onAddExerciseOutput(output: AddExerciseComponent.Output) {
        when (output) {
            is AddExerciseComponent.Output.BackPressed -> navigation.pop()
            is AddExerciseComponent.Output.ExerciseAdded -> navigation.pop()
        }
    }

    private fun createMainComponent(componentContext: ComponentContext): MainComponent =
        DefaultMainComponent(componentContext = componentContext, onOutput = ::onMainOutput)

    private fun onMainOutput(output: MainComponent.Output) {
        when (output) {
            MainComponent.Output.WorkoutStarted -> navigation.push(Config.Workout)
        }
    }

    private fun createWorkoutComponent(componentContext: ComponentContext): WorkoutComponent =
        DefaultWorkoutComponent(componentContext = componentContext, onOutput = ::onWorkoutOutput)

    private fun onWorkoutOutput(output: WorkoutComponent.Output) {
        when (output) {
            WorkoutComponent.Output.BackPressed -> navigation.pop()
            WorkoutComponent.Output.AddExercisePressed -> navigation.push(Config.AddExercise)
        }
    }

    @Parcelize
    private sealed interface Config : Parcelable {
        @Parcelize
        object Main : Config

        @Parcelize
        object Workout : Config

        @Parcelize
        object AddExercise : Config

        @Parcelize
        data class WorkoutWithNewExercise(val exercise: Exercise) : Config
    }
}
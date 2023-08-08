package com.example.hevyclone.data

import com.example.hevyclone.model.Exercise
import com.example.hevyclone.model.OngoingExercise
import com.example.hevyclone.model.getMockOngoingExercises

interface OngoingExerciseRepository {
    fun getExercises(): List<OngoingExercise>

    fun addExercise(newExercise: Exercise)
}

class DefaultOngoingExerciseRepository() : OngoingExerciseRepository {
    private var exerciseStorage:List<OngoingExercise> = getMockOngoingExercises()

    override fun getExercises(): List<OngoingExercise> {
        return exerciseStorage
    }

    override fun addExercise(newExercise: Exercise) {
        val newOngoingExercise = OngoingExercise(
            exercise = newExercise,
            notes = "",
            sets = listOf()
        )
        exerciseStorage = getMockOngoingExercises() + newOngoingExercise
    }
}

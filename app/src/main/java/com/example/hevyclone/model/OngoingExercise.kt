package com.example.hevyclone.model

data class OngoingExercise(
    val exercise: Exercise,
    val notes: String,
    val sets: List<HevySet>
)

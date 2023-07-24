package com.example.hevyclone.model

fun getMockExercises(): List<Exercise> {
    return listOf(Exercise(
        title = "Bench Press",
        notes = "",
        sets = listOf(
            HevySet(
                setNumber = 1,
                previous = "5kgx10",
                weight = 5.4,
                reps = 8,
                done = true
            )
        )
    ),
        Exercise(
            title = "Incline Bench Press",
            notes = "Do your bench press",
            sets = listOf(
                HevySet(
                    setNumber = 1,
                    previous = "",
                    weight = 53,
                    reps = 2,
                    done = true
                ),
                HevySet(
                    setNumber = 2,
                    previous = "5kgx10",
                    weight = 5,
                    reps = 33,
                    done = true
                )
            )
        )
    )
}
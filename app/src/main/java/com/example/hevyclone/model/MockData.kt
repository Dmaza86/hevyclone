package com.example.hevyclone.model

fun getMockOngoingExercises(): List<OngoingExercise> {
    return listOf(
        OngoingExercise(
            exercise = getMockExerciseDisplayed().find { it.name == "Front Squat" }!!,
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
        OngoingExercise(
            exercise = getMockExerciseDisplayed().find { it.name == "Plank" }!!,
            notes = "Do your bench press",
            sets = listOf(
                HevySet(
                    setNumber = 1,
                    previous = "",
                    weight = 53,
                    reps = 2,
                    done = false
                ),
                HevySet(
                    setNumber = 2,
                    previous = "5kgx10",
                    weight = 5,
                    reps = 33,
                    done = false
                )
            )
        )
    )
}

fun getMockExerciseDisplayed(): List<Exercise> {
    return listOf(
        Exercise(
            name = "Front Squat",
            mainMuscle = "Quadriceps",
        ),
        Exercise(
            name = "Deadlift (Dumbbell)",
            mainMuscle = "Hamstring",
        ),
        Exercise(
            name = "Lunge (Dumbbell)",
            mainMuscle = "Quadriceps",
        ),
        Exercise(
            name = "Plank",
            mainMuscle = "Abdominals",
        ),
        Exercise(
            name = "Lat Pulldown(band)",
            mainMuscle = "Lats",
        ),
        Exercise(
            name = "Shrug (Dumbbell)",
            mainMuscle = "Upper Back",
        ),
        Exercise(
            name = "EZ Bar Biceps Curl",
            mainMuscle = "Biceps",
        ),
        Exercise(
            name = "Push Up",
            mainMuscle = "Chest",
        )
    )
}
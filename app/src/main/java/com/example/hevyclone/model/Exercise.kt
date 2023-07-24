package com.example.hevyclone.model

data class Exercise(
    val title: String,
    val notes: String,
    val sets: List<HevySet>
)

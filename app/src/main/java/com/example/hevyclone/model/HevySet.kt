package com.example.hevyclone.model

data class HevySet(
    val setNumber: Int,
    val previous: String,
    val weight: Number,
    val reps: Int,
    val done: Boolean
)
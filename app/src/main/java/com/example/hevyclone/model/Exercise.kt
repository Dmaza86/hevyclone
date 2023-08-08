package com.example.hevyclone.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Exercise (
    val name:String,
    val mainMuscle:String,
): Parcelable
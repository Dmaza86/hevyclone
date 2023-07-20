package com.example.hevyclone

import StartEmptyWorkout
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.theme.HevyPreviewTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           HevyPreviewTheme {
               StartEmptyWorkout()
            }
        }
    }
}
@Preview
@Composable
fun WorkoutsPreview() {
    HevyPreviewTheme {
       StartEmptyWorkout()
    }
}
package com.example.hevyclone

import StartEmptyWorkout
import android.content.res.Configuration
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.screen.Workout
import com.example.hevyclone.ui.ui.HevyCloneTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HevyCloneTheme {
              StartEmptyWorkout()
            }
        }
    }
}
@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WorkoutsPreview() {
    HevyCloneTheme {
        Workout()
    }
}
@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import android.content.res.Configuration
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun Workouts() {
    CenterAlignedTopAppBar(
        title = { Text(text = "Workouts")},
        navigationIcon = {
            TextButton(onClick = {}) {
                Text(text = "PRO", color = Color.Yellow, fontSize = 20.sp, fontWeight = FontWeight.ExtraBold)
            }
        },
        actions = {
            IconButton(onClick = {}) {
                Icon(imageVector = Icons.Filled.Refresh,
                    contentDescription = "Localized description" )
            }
        }
    )
}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WorkoutsPreview() {
    HevyCloneTheme {
        Workouts()
    }
}

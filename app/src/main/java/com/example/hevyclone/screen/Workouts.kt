@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hevyclone.R
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun Workouts() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Workouts") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.DarkGray),
                navigationIcon = {
                    TextButton(onClick = {}) {
                        Text(
                            text = "PRO",
                            color = Color.Yellow,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold
                        )
                    }
                },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Refresh,
                            contentDescription = null
                        )
                    }
                }
            )
        },
        bottomBar = {
            NavigationBar (containerColor = Color.DarkGray) {
                NavigationBarItem(
                    icon = {
                        Icon(Icons.Outlined.Home,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)) },
                    label = { Text(text = "Home")},
                    selected = false,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(painter = painterResource(id = R.drawable.dumbbell),
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)) },
                    label = { Text(text = "Workout") },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = { Icon(Icons.Outlined.Person, contentDescription = null, modifier = Modifier.size(30.dp))},
                    label = { Text(text = "Profile")},
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) { contentPadding ->
        Text(
            text = "Quick Start",
            modifier = Modifier.padding(contentPadding),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp
        )
    }
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

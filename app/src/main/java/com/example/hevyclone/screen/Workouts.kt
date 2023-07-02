@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.component.HeavyTitleMedium
import com.example.hevyclone.ui.component.HevyIconTitleButton
import com.example.hevyclone.ui.component.HevyCard
import com.example.hevyclone.ui.ui.HevyCloneTheme
import com.example.hevyclone.ui.component.HevySecondaryButton
import com.example.hevyclone.ui.component.HevyIconButton

@Composable
fun Workouts() {
    Scaffold(topBar = {
        CenterAlignedTopAppBar(title = {
            Text(
                text = "Workout",
                style = MaterialTheme.typography.titleLarge
            )
        },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.DarkGray),
            navigationIcon = {
                TextButton(onClick = {}) {
                    Text(
                        text = "PRO",
                        color = Color.Yellow,
                        fontWeight = FontWeight.ExtraBold,
                        style = MaterialTheme.typography.titleLarge
                    )
                }
            },
            actions = {
                HevyIconButton(
                    modifier = Modifier.padding(end = 8.dp),
                    iconImageVector = Icons.Default.Refresh
                )
            })
    }, bottomBar = {
        NavigationBar(containerColor = Color.DarkGray) {
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Outlined.Home,
                        modifier = Modifier.size(30.dp),
                        contentDescription = null,
                    )
                }, label = { Text(text = "Home") },
                selected = false,
                onClick = {})
            NavigationBarItem(
                icon = {
                    Icon(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.dumbbell),
                        contentDescription = null,
                    )
                }, label = { Text(text = "Workout") },
                selected = true,
                onClick = {})
            NavigationBarItem(
                icon = {
                    Icon(
                        Icons.Outlined.Person,
                        contentDescription = null,
                        modifier = Modifier.size(30.dp)
                    )
                }, label = { Text(text = "Profile") },
                selected = false,
                onClick = {})
        }
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row {
                HeavyTitleMedium(text = "Quick Start")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                HevySecondaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Start Empty Workout",
                    iconImageVector = Icons.Default.Add
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HeavyTitleMedium(text = "Routines")
                HevyIconButton(iconDrawableId = R.drawable.new_folder)
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HevySecondaryButton(
                    modifier = Modifier.weight(1f),
                    text = "New Routine",
                    iconDrawableId = R.drawable.clipboard
                )
                Spacer(modifier = Modifier.width(8.dp))
                HevySecondaryButton(
                    modifier = Modifier.weight(1f),
                    text = "Explore",
                    iconImageVector = Icons.Default.Search
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HevyIconTitleButton(
                    text = "Phase 2:",
                    iconImageVector = Icons.Default.ArrowDropDown
                )
                HevyIconButton(
                    iconDrawableId = R.drawable.more_horizontal
                )
            }
            Column {
                HevyCard(
                    title = "Push #1",
                    text = "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback.",
                    buttonLabel = "Start Routine"
                )
                HevyCard(
                    title = "Legs #1",
                    text = "Squat, Deadlift, Leg Extension, Seated Calf Raise Cable.",
                    buttonLabel = "Start Routine"
                )
            }
        }
    }
}

@Preview
@Composable
fun WorkoutsPreview() {
    HevyCloneTheme(darkTheme = true) {
        Workouts()
    }
}

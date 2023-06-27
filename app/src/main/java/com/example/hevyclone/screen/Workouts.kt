@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.unit.sp
import com.example.hevyclone.R
import com.example.hevyclone.ui.ui.HevyCloneTheme
import com.example.hevyclone.ui.ui.component.HevyButtons

@Composable
fun Workouts() {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = "Workouts", style = MaterialTheme.typography.titleLarge) },
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
            NavigationBar(containerColor = Color.DarkGray) {
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Outlined.Home,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    label = { Text(text = "Home") },
                    selected = false,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            painter = painterResource(id = R.drawable.dumbbell),
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    label = { Text(text = "Workout") },
                    selected = true,
                    onClick = {}
                )
                NavigationBarItem(
                    icon = {
                        Icon(
                            Icons.Outlined.Person,
                            contentDescription = null,
                            modifier = Modifier.size(30.dp)
                        )
                    },
                    label = { Text(text = "Profile") },
                    selected = false,
                    onClick = {}
                )
            }
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Text(
                text = "Quick Start",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row()
            {
                HevyButtons(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Start Empty Workout",
                    icon = { contentDescription, modifier, tint ->
                        Icon(
                            imageVector = Icons.Default.Add,
                            contentDescription = contentDescription,
                            modifier = modifier,
                            tint = tint
                        )
                    },
                )
                Spacer(modifier = Modifier.height(60.dp))
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Text(
                    text = "Routines",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    style = MaterialTheme.typography.titleMedium
                )
                Icon(
                    painter = painterResource(id = R.drawable.new_folder),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Cyan
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HevyButtons(
                    modifier = Modifier.weight(1f),
                    text = "New Routine",
                    icon = { contentDescription, modifier, tint ->
                        Icon(
                            painter = painterResource(id = R.drawable.clipboard),
                            contentDescription = contentDescription,
                            modifier = modifier,
                            tint = tint
                        )
                    },
                )
                HevyButtons(
                    modifier = Modifier.weight(1f),
                    text = "Explore Routines",
                    icon = { contentDescription, modifier, tint ->
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = contentDescription,
                            modifier = modifier,
                            tint = tint
                        )
                    }
                )
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
        Workouts()
    }
}

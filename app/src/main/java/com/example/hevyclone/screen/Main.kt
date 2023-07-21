@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen


import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.component.HevyIconButton
import com.example.hevyclone.ui.theme.HevyPreviewTheme

sealed class Tab {
    object Home : Tab()
    object Workout : Tab()
    object Profile : Tab()
}

data class HevyNavItem(
    val icon: @Composable () -> Unit,
    val label: String,
    val tab: Tab
)

@Composable
fun Main() {
    var selectedTab: Tab by remember { mutableStateOf(Tab.Workout) }

    val folders = remember {
        mutableStateOf(
            listOf(
                Folder(
                    "Phase0", emptyList(
                    )
                ),
                Folder(
                    "Phase1", listOf(
                        Routine(
                            "Push",
                            "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback."
                        ),
                        Routine(
                            "Leg",
                            "Calf, Squats"
                        )
                    )
                ),
                Folder(
                    "Phase2", listOf(
                        Routine(
                            "Push",
                            "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback."
                        ),
                        Routine(
                            "Leg",
                            "Calf, Squats"
                        )
                    )
                )
            )
        )
    }

    var tabs: List<HevyNavItem> by remember {
        mutableStateOf(
            listOf(
                HevyNavItem(
                    icon = {
                        Icon(
                            Icons.Outlined.Home,
                            modifier = Modifier.size(30.dp),
                            contentDescription = null
                        )
                    },
                    label = "Home",
                    tab = Tab.Home,
                ),
                HevyNavItem(
                    icon = {
                        Icon(
                            painterResource(id = R.drawable.dumbbell),
                            modifier = Modifier.size(30.dp),
                            contentDescription = null
                        )
                    },
                    label = "Workout",
                    tab = Tab.Workout
                ),
                HevyNavItem(
                    icon = {
                        Icon(
                            Icons.Outlined.Person,
                            modifier = Modifier.size(30.dp),
                            contentDescription = null
                        )
                    },
                    label = "Profile",
                    tab = Tab.Profile
                )
            )
        )
    }

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = {
                Text(
                    text = "Workout",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.onPrimary
                )
            },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = MaterialTheme.colorScheme.primary),
                navigationIcon = {
                    TextButton(onClick = {}) {
                        Text(
                            text = "PRO",
                            color = MaterialTheme.colorScheme.tertiary,
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
            NavigationBar(
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                tabs.forEach { tab ->
                    NavigationBarItem(
                        icon = tab.icon,
                        label = { Text(text = tab.label) },
                        selected = selectedTab == tab.tab,
                        colors = NavigationBarItemDefaults.colors(
                            selectedTextColor = MaterialTheme.colorScheme.secondary,
                            selectedIconColor = MaterialTheme.colorScheme.secondary,
                            indicatorColor = MaterialTheme.colorScheme.primary
                        ),
                        onClick = { selectedTab = tab.tab }
                    )
                }
            }
        }) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            when (selectedTab) {
                is Tab.Workout -> workoutTab(folders.value)
                is Tab.Home -> homeTab()
                is Tab.Profile -> profileTab()
            }
        }
    }
}

@Preview
@Composable
fun MainPreview() {
    HevyPreviewTheme {
        Main()
    }
}
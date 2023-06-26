@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.hevyclone.screen

import android.content.res.Configuration
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.hevyclone.ui.theme.HevyCloneTheme
import item.BottomNavItem

@Composable
fun Workouts() {
    val navController = rememberNavController()

    var selectedItem = remember { mutableStateOf(0) }
    val items = listOf("Home", "Workouts", "Profile")

    Scaffold(
        topBar ={
            CenterAlignedTopAppBar(
                title ={Text(text = "Workouts")},
                navigationIcon ={
                    TextButton(onClick ={}){
                        Text(text = "PRO",
                            color = Color.Yellow,
                            fontSize = 20.sp,
                            fontWeight = FontWeight.ExtraBold)
                    }
                },
                actions ={
                    IconButton(onClick ={}){
                        Icon(imageVector = Icons.Filled.Refresh,
                            contentDescription = null )
                    }
                }
            )
        },
        bottomBar = {


NavigationBar {
    items.forEachIndexed { index, item ->
        NavigationBarItem(
            icon = { Icon(Icons.Filled.Favorite, contentDescription = item) },
            label = { Text(item) },
            selected = (selectedItem.value == index),
            onClick = { selectedItem.value = index }
        )
    }
}
        }
    ) { contentPadding ->
        Text(text = "Quick Start",
            modifier = Modifier.padding(contentPadding),
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp)
    }
}
@Composable
fun Navigation(navController: NavHostController){
    NavHost(navController = navController, startDestination = "workout" ){
        composable("home"){
            Home()
        }
        composable("workout"){
            Workouts()
        }
        composable("profile"){
            Profile()
        }
    }
}
//@Composable
//fun BottomNavigationBar(
//    items: List<BottomNavItem>,
//    navController: NavHostController,
//    modifier: Modifier = Modifier,
//    onItemClick: (BottomNavItem)-> Unit
//) {
//    val backStackEntry = navController.currentBackStackEntryAsState()
//    NavigationBar(
//        modifier = modifier,
//        containerColor = Color.Black,
//        tonalElevation = 5.dp
//    ) {
//        items.forEach {item ->
//            val selected = item.route == backStackEntry.value?.destination?.route
//            NavigationBarItem(
//                selected = selected,
//                onClick = { onItemClick(item) },
//                colors = NavigationBarItemDefaults.colors(
//                    selectedIconColor = Color.Blue,
//                    unselectedIconColor = Color.Gray
//                ),
//                icon = {
//                    Column(horizontalAlignment = CenterHorizontally) {
//                        Text(
//                            text = item.name,
//                            textAlign = TextAlign.Center,
//                            fontSize = 10.sp,
//                        )
//                    }
//                    }
//                )
//        }
//    }
//}

@Preview(
    uiMode = Configuration.UI_MODE_NIGHT_YES or Configuration.UI_MODE_TYPE_NORMAL
)
@Composable
fun WorkoutsPreview() {
    HevyCloneTheme {
        Workouts()
    }
}

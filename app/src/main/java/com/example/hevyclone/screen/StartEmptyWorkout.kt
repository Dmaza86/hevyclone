@file:OptIn(ExperimentalMaterial3Api::class)

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.component.HeavyTitleMedium
import com.example.hevyclone.ui.component.HevyDoubleTextButton
import com.example.hevyclone.ui.component.HevyIconButton
import com.example.hevyclone.ui.component.HevyPrimaryButton
import com.example.hevyclone.ui.component.HevySecondaryButton
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun StartEmptyWorkout() {
    Scaffold(topBar = {
        TopAppBar(title = {
            Text(
                text = "Log Workout", style = MaterialTheme.typography.titleLarge, maxLines = 1
            )
        },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = Color.DarkGray),
            navigationIcon = {
                HevyIconButton(
                    modifier = Modifier.size(350.dp),
                    iconImageVector = Icons.Outlined.KeyboardArrowDown
                )
            },
            actions = {
                HevyIconButton(
                    modifier = Modifier
                        .size(350.dp)
                        .padding(end = 8.dp),
                    iconDrawableId = R.drawable.timer
                )
                HevyPrimaryButton(
                    modifier = Modifier.padding(end = 8.dp),
                    buttonLabel = "Finish",
                    buttonWidth = 100.dp
                )
            })
    }) { contentPadding ->
        Divider(color = Color.LightGray, thickness = 70.dp)
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(contentPadding)
                .padding(horizontal = 16.dp, vertical = 16.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxSize(),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                HevyDoubleTextButton(title = "Duration", content = "9s", color = Color.Cyan)
                HevyDoubleTextButton(title = "Volume", content = "0 lbs")
                HevyDoubleTextButton(title = "Sets", content = "0")
            }
            Divider(color = Color.LightGray, thickness = 2.dp)
            Spacer(modifier = Modifier.height(30.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            )
            {
                Icon(
                    painter = painterResource(id = R.drawable.dumbbell_horizontal),
                    tint = Color.White,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                HeavyTitleMedium(text = "Get started")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Add an exercise to start your workout")
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center
            ) {
                HevyPrimaryButton(
                    modifier = Modifier.fillMaxWidth(),
                    buttonLabel = "+ Add Exercise"
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                HevySecondaryButton(
                    modifier = Modifier.weight(1f),
                    text = "Settings"
                )
                Spacer(modifier = Modifier.width(8.dp))
                HevySecondaryButton(
                    modifier = Modifier.weight(1f),
                    text = "Discard Workout",
                    color = Color.Red
                )
            }
        }
    }
}

@Preview
@Composable
fun StartEmptyWorkoutPreview() {
    HevyCloneTheme(darkTheme = true) {
        StartEmptyWorkout()
    }
}
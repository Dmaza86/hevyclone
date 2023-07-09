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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.KeyboardArrowDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.component.HeavyTitleMedium
import com.example.hevyclone.ui.component.HevyBasicTextField
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
                text = "Log Workout",
                style = MaterialTheme.typography.titleLarge.copy(MaterialTheme.colorScheme.onPrimary),
                maxLines = 1
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
                HevyPrimaryButton(label = "Finish")
            })
    }) { contentPadding ->
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxWidth()
                .padding(contentPadding)
        ) {
            Divider(color = Color.LightGray, thickness = 4.dp)
            Row(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                HevyDoubleTextButton(
                    title = "Duration",
                    content = "9s",
                    color = MaterialTheme.colorScheme.secondary
                )
                HevyDoubleTextButton(title = "Volume", content = "0 lbs")
                HevyDoubleTextButton(title = "Sets", content = "0")
            }
            Divider(color = Color.LightGray, thickness = 1.dp)

            Column(modifier = Modifier.padding(horizontal = 16.dp, vertical = 16.dp)) {
                if (true) {
                    EmptyView()
                }
                Card(
                    modifier = Modifier.fillMaxWidth(),
                    colors = CardDefaults.cardColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween
                    )
                    {
                        TextButton(
                            onClick = {},
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent,
                                contentColor = MaterialTheme.colorScheme.secondary
                            )
                        ) {
                            Icon(
                                painterResource(id = R.drawable.clipboard),
                                contentDescription = null,

                                )
                            Text(
                                text = "Ab Scissors",
                                modifier = Modifier.padding(start = 8.dp),
                                style = MaterialTheme.typography.titleLarge
                            )
                        }
                        HevyIconButton(iconImageVector = Icons.Default.MoreVert)
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        HevyBasicTextField(
                            placeholder = "Add notes here...",
                            style = MaterialTheme.typography.bodyLarge,
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
                        )
                    }
                    Row(modifier = Modifier.fillMaxWidth()) {
                        TextButton(onClick = {}) {
                            HevyIconButton(iconDrawableId = R.drawable.restart)
                            Text(
                                text = "Rest Timer: OFF",
                                color = MaterialTheme.colorScheme.secondary,
                                style = MaterialTheme.typography.titleMedium
                            )
                        }
                    }
//                    HevyTable(
//                        textHeader1 = "SET",
//                        textHeader2 = "PREVIOUS",
//                        textHeader3 = "KG",
//                        textHeader4 = "REPS",
//                        iconImageVector = Icons.Outlined.Check,
//                        textColumn1 = "1",
//                        textColumn2 = "-",
//                        placeholder1 = "0",
//                        placeholder2 = "0"
//                    )
                    Row {
                        HevySecondaryButton(
                            text = "+ Add Set",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    HevyPrimaryButton(
                        label = "+ Add Exercise",
                        modifier = Modifier.fillMaxWidth()
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row()
                {
                    HevySecondaryButton(
                        modifier = Modifier.weight(1f),
                        text = "Settings",
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    HevySecondaryButton(
                        modifier = Modifier.weight(1f),
                        text = "Discard Workout",
                        textColor = MaterialTheme.colorScheme.onError
                    )
                }
            }
        }
    }
}

@Composable
private fun EmptyView() {
    Column {
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
            Text(
                text = "Add an exercise to start your workout",
                color = MaterialTheme.colorScheme.onSurface
            )
        }
        Spacer(modifier = Modifier.height(8.dp))
    }
}

@Preview
@Composable
fun StartEmptyWorkoutPreview() {
    HevyCloneTheme(darkTheme = true) {
        StartEmptyWorkout()
    }
}

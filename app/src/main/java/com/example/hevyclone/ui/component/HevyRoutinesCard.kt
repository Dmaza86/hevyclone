package com.example.hevyclone.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.theme.HevyPreviewTheme

@Composable
fun HevyRoutinesCard(
    title: String,
    text: String,
    label: String,
    cardColor: CardColors = CardDefaults.cardColors(MaterialTheme.colorScheme.primary),
    textColor: Color = MaterialTheme.colorScheme.onSurface
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .padding(bottom = 16.dp)
            .clickable { },
        colors = cardColor,

        ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 4.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                HevyTitleMedium(
                    modifier = Modifier.weight(1f),
                    text = title
                )
                HevyIconButton(
                    modifier = Modifier.weight(1f),
                    iconDrawableId = R.drawable.more_horizontal,
                )
            }
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                color = textColor,
                maxLines = 2,
            )
            HevyPrimaryButton(label = label, modifier = Modifier.fillMaxWidth())
        }
    }
}

@Preview
@Composable
fun HevyCardPreview() {
    HevyPreviewTheme {
        HevyRoutinesCard(
            title = "Push #1",
            text = "Bench Press, Incline Bench Press, Lateral Raise, Triceps Extension, Cable Triceps Kickback.",
            label = "Start Routine"
        )
    }
}
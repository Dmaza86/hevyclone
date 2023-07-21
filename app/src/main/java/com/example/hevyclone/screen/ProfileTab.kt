package com.example.hevyclone.screen

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.hevyclone.ui.theme.HevyPreviewTheme


fun LazyListScope.profileTab() {
    item {
        Text(
            text = "No Profile content available",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onSecondary,
            textAlign = TextAlign.Center
        )
    }
}

@Preview
@Composable
fun ProfileTabPreview() {
    HevyPreviewTheme {
        LazyColumn {
            profileTab()
        }
    }
}
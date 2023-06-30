package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyPrimaryButton (buttonLabel:String) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom
    ) {
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            onClick = {},
            shape = RoundedCornerShape(8.dp),
            colors = ButtonDefaults.buttonColors(Color.Cyan)
        ) {
            Text(
                text = buttonLabel,
                color = Color.White
            )
        }
    }
}

@Preview
@Composable
fun HevyPrimaryButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevyPrimaryButton(buttonLabel = "Start Routine"
        )
    }
}
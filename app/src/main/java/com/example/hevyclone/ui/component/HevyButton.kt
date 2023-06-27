package com.example.hevyclone.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HevyButton(
    modifier: Modifier = Modifier,
    text: String,
    icon: @Composable (contentDescription: String?, modifier:Modifier, tint: Color) -> Unit,
    contentDescription: String? = null,
    tint: Color = Color.Cyan,
    Onclick:()-> Unit = {}
){
    Button(
        modifier = modifier,
        onClick = Onclick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        shape = RectangleShape
    )
    {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start)
        {
            icon(contentDescription, Modifier.size(30.dp), tint)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                color = Color.White,
                fontSize = 16.sp,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}
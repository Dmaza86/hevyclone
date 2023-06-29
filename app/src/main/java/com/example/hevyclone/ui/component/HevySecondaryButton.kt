package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevySecondaryButton(
    modifier: Modifier = Modifier,
    text: String,
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        shape = RectangleShape
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (iconImageVector != null) {
                Icon(
                    imageVector = iconImageVector,
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Cyan
                )
            } else if (iconDrawableId != null) {
                Icon(
                    painter = painterResource(id = iconDrawableId),
                    contentDescription = null,
                    modifier = Modifier.size(30.dp),
                    tint = Color.Cyan
                )
            }
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

@Preview
@Composable
fun HevySecondaryButtonPreview() {
    HevyCloneTheme (darkTheme = true, dynamicColor = false) {
        HevySecondaryButton(
            text = "Button", iconImageVector = Icons.Default.Favorite
        )
    }
}

package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyIconTitleButton(
    modifier: Modifier = Modifier,
    text: String,
    fontWeight: FontWeight = FontWeight.Normal,
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {}
) {
    TextButton(
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = Color.DarkGray)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
                if (iconImageVector != null) {
                    Icon(
                        modifier = modifier then Modifier.size(20.dp),
                        imageVector = iconImageVector,
                        contentDescription = null,
                        tint = Color.Gray
                    )
                } else if (iconDrawableId != null) {
                    Icon(
                        modifier = modifier then Modifier.size(20.dp),
                        painter = painterResource(id = iconDrawableId),
                        contentDescription = null,
                        tint = Color.Gray
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
                    fontWeight = fontWeight,
                    style = MaterialTheme.typography.titleSmall
                )

        }
    }
}

@Preview
@Composable
fun HevyIconTitleButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevyIconTitleButton(text = "Button", iconImageVector = Icons.Default.ArrowDropDown)
    }
}

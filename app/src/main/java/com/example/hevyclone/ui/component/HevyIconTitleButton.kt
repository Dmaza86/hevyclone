package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyIconTitleButton(
    modifier: Modifier = Modifier,
    text: String,
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {}
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.textButtonColors(contentColor = MaterialTheme.colorScheme.primary),
        contentPadding = PaddingValues(0.dp),
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
                if (iconImageVector != null) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        imageVector = iconImageVector,
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                } else if (iconDrawableId != null) {
                    Icon(
                        modifier = Modifier.size(20.dp),
                        painter = painterResource(id = iconDrawableId),
                        contentDescription = null,
                        tint = MaterialTheme.colorScheme.primary
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = text,
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

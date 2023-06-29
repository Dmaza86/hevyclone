package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevyIconButton(
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {},
    tint: Color = Color.Cyan
) {
    IconButton(onClick = onClick) {
        if (iconImageVector != null) {
            Icon(
                imageVector = iconImageVector,
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = tint
            )
        } else if (iconDrawableId != null) {
            Icon(
                painter = painterResource(id = iconDrawableId),
                contentDescription = null,
                modifier = Modifier.size(30.dp),
                tint = tint
            )
        }
    }
}

@Preview
@Composable
fun HevyIconButtonPreview() {
    HevyCloneTheme (darkTheme = true, dynamicColor = false) {
        HevySecondaryButton(
        text = "New Routine",
        iconDrawableId = R.drawable.clipboard
        )
    }
}


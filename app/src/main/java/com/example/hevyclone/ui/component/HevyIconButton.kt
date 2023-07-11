package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.R
import com.example.hevyclone.ui.theme.HevyCloneTheme

@Composable
fun HevyIconButton(
    modifier: Modifier = Modifier,
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {},
    tint:Color = MaterialTheme.colorScheme.secondary
) {
    IconButton(onClick = onClick) {
        if (iconImageVector != null) {
            Icon(
                modifier = modifier then Modifier.size(30.dp),
                imageVector = iconImageVector,
                contentDescription = null,
                tint = tint
            )
        } else if (iconDrawableId != null) {
            Icon(
                modifier = modifier then Modifier.size(30.dp),
                painter = painterResource(id = iconDrawableId),
                contentDescription = null,
                tint = tint
            )
        }
    }
}

@Preview
@Composable
fun HevyIconButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevyIconButton(iconDrawableId = R.drawable.clipboard)
    }
}


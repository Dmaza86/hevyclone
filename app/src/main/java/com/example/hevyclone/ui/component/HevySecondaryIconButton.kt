package com.example.hevyclone.ui.component

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.hevyclone.ui.ui.HevyCloneTheme

@Composable
fun HevySecondaryIconButton(
    modifier: Modifier = Modifier,
    text: String,
    iconImageVector: ImageVector? = null,
    @DrawableRes iconDrawableId: Int? = null,
    onClick: () -> Unit = {},
    colors: ButtonColors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary),
    tint: Color = MaterialTheme.colorScheme.secondary

) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = colors,
        shape = RoundedCornerShape(8.dp)
    ) {
        Row(
            Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start
        ) {
            if (iconImageVector != null) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    imageVector = iconImageVector,
                    contentDescription = null,
                    tint = tint
                )
            } else if (iconDrawableId != null) {
                Icon(
                    modifier = Modifier.size(30.dp),
                    painter = painterResource(id = iconDrawableId),
                    contentDescription = null,
                    tint = tint
                )
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = text,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}

@Preview
@Composable
fun HevySecondaryIconButtonPreview() {
    HevyCloneTheme(darkTheme = true, dynamicColor = false) {
        HevySecondaryIconButton(
            text = "New Routine", iconImageVector = Icons.Default.Favorite
        )
    }
}

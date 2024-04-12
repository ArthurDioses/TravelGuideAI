package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 12/04/24 at 1:08 AM
 * All rights reserved 2024.
 ****/
@Composable
fun HomeFilterSettingsButton(
    onClick: () -> Unit,
    icon: ImageVector?,
    modifier: Modifier = Modifier,
) {
    OutlinedButton(
        onClick = onClick,
        modifier = modifier.defaultMinSize(ButtonDefaults.MinHeight, ButtonDefaults.MinHeight),
        colors = ButtonDefaults.outlinedButtonColors(containerColor = Color.Transparent),
        shape = RoundedCornerShape(10.dp),
        contentPadding = PaddingValues(0.dp)
    ) {
        if (icon != null) {
            Icon(
                imageVector = icon, contentDescription = "plus", tint = Color.Green
            )
        }
    }
}

@Preview
@Composable
private fun HomeFilterSettingButtonPreview() {
    HomeFilterSettingsButton(onClick = {}, icon = Icons.Default.Add)

}
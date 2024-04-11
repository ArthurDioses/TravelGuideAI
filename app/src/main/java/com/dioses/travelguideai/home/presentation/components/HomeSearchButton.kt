package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 11/04/24 at 10:04 AM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeSearchButton(
    icon: ImageVector,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick, modifier = modifier.background(Color.Green, shape = CircleShape)
    ) {
        Icon(imageVector = icon, contentDescription = "search", tint = Color.White)
    }
}

@Preview
@Composable
fun HomeSearchButtonPreview() {
    HomeSearchButton(icon = Icons.Default.Search, onClick = {})
}
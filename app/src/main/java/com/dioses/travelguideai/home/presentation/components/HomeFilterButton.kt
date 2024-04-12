package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 11/04/24 at 9:44 PM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeFilerButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    IconButton(
        onClick = onClick,
        modifier = modifier.background(color = Color.LightGray, shape = RoundedCornerShape(13.dp))
    ) {
        Icon(imageVector = Icons.Default.List, contentDescription = "filter", tint = Color.Gray)
    }
}

@Preview
@Composable
fun HomeFilerButtonPreview() {
    HomeFilerButton(onClick = {})
}
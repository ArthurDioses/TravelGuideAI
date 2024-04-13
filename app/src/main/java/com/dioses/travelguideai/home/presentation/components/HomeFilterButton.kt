package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Tune
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dioses.travelguideai.ui.theme.FilterColor
import com.dioses.travelguideai.ui.theme.FilterGray

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
        modifier = modifier.background(color = FilterGray, shape = RoundedCornerShape(13.dp))
    ) {
        Icon(imageVector = Icons.Default.Tune, contentDescription = "filter", tint = FilterColor)
    }
}

@Preview
@Composable
fun HomeFilerButtonPreview() {
    HomeFilerButton(onClick = {})
}
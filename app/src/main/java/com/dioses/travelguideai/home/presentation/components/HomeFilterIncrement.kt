package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 12/04/24 at 12:53 AM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeFilterIncrement(
    number: Int,
    onMinus: () -> Unit,
    onPlus: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        HomeFilterSettingsButton(onMinus, Icons.Default.Remove)
        Text(text = "$number")
        HomeFilterSettingsButton(onPlus, Icons.Default.Add)
    }
}

@Preview
@Composable
fun HomeFilterIncrementPreview() {
    HomeFilterIncrement(number = 5, onMinus = {}, onPlus = {})
}
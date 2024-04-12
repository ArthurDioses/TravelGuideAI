package com.dioses.travelguideai.home.presentation.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 12/04/24 at 12:53 AM
 * All rights reserved 2024.
 ****/

@Composable
fun HomeFilterCheckBox(
    onclick: () -> Unit,
    isChecked: Boolean,
    modifier: Modifier = Modifier,
) {
    val icon = if (isChecked) Icons.Default.Check else null
    HomeFilterSettingsButton(onClick = onclick, icon = icon, modifier)
}

@Preview
@Composable
fun HomeFilterCheckBoxPreview() {
    HomeFilterCheckBox(onclick = {}, false)
}
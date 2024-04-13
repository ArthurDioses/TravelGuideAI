package com.dioses.travelguideai.home.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.tooling.preview.Preview
import com.dioses.travelguideai.home.domain.model.Region
import com.dioses.travelguideai.ui.theme.DarkGreen

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation.components
 * Created by Arthur Dioses Reto on 12/04/24 at 6:05 PM
 * All rights reserved 2024.
 ****/

@Composable
fun HomePopularFilter(
    selectedRegion: Region,
    selectRegion: (Region) -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Region.entries.forEach {
            val textColor = if (it == selectedRegion) DarkGreen else Color.Gray
            TextButton(
                onClick = { selectRegion(it) },
                colors = ButtonDefaults.textButtonColors(contentColor = DarkGreen)
            ) {
                Text(text = it.name.lowercase().capitalize(Locale.current), color = textColor)
            }
        }
    }
}

@Preview
@Composable
fun HomePopularFilterPreview() {
    HomePopularFilter(selectedRegion = Region.OCEANIA, {})
}
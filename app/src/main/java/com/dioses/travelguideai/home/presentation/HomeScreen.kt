package com.dioses.travelguideai.home.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.dioses.travelguideai.home.presentation.components.HomeFilerButton
import com.dioses.travelguideai.home.presentation.components.HomeFilterDialog
import com.dioses.travelguideai.home.presentation.components.HomeSearchBar

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation
 * Created by Arthur Dioses Reto on 10/04/24 at 10:12 PM
 * All rights reserved 2024.
 ****/
@Composable
fun HomeScreen(
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val state = viewModel.state

    if (state.showDialog) {
        HomeFilterDialog(
            onDismiss = { viewModel.onFilterDismiss() },
            filterSettings = state.filterSettings, onAction = {
                viewModel.onSettingsChange(it)
            }
        )
    }

    Column(modifier = Modifier.fillMaxSize()) {
        Text(text = "A donde viajas?")
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            HomeSearchBar(
                onSearch = {
                    viewModel.search()
                },
                placeholder = "Pais, Ciudad",
                inputText = state.searchText,
                onValueChange = { viewModel.onSearchTextChange(it) }
            )
            HomeFilerButton(onClick = { viewModel.onFilterClick() })
        }
    }
}
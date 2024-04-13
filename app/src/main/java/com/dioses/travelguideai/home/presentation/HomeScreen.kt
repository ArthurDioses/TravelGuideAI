package com.dioses.travelguideai.home.presentation

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.dioses.travelguideai.home.presentation.components.HomeFilerButton
import com.dioses.travelguideai.home.presentation.components.HomeFilterDialog
import com.dioses.travelguideai.home.presentation.components.HomePopularFilter
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

    BackHandler(state.chatReply != null) {
        viewModel.onBackPress()
    }

    LazyColumn(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.spacedBy(32.dp),
        contentPadding = PaddingValues(vertical = 32.dp)
    ) {
        item {
            Text(
                text = "A donde viajas?",
                fontSize = 28.sp,
                modifier = Modifier.padding(horizontal = 16.dp)
            )
        }
        item {
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
            Spacer(modifier = Modifier.height(32.dp))
        }

        if (state.isLoading) {
            item {
                Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                    CircularProgressIndicator()
                }
            }
        } else {
            state.chatReply?.let {
                item {
                    Text(text = it, modifier = Modifier.padding(horizontal = 16.dp))
                }
            } ?: item {
                if (state.popularPlaces.isNotEmpty()) {
                    Column(modifier = Modifier.fillMaxWidth()) {
                        Text(
                            text = "Lugares populares",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(horizontal = 16.dp)
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        HomePopularFilter(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp),
                            selectedRegion = state.selectedRegion,
                            selectRegion = {
                                viewModel.onRegionSelect(it)
                            }
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        LazyRow(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.spacedBy(24.dp),
                            contentPadding = PaddingValues(horizontal = 16.dp)
                        ) {
                            items(state.popularPlaces) {
                                Box(
                                    modifier = Modifier
                                        .size(150.dp, 250.dp)
                                        .clip(RoundedCornerShape(20.dp))
                                        .clickable {
                                            viewModel.onSearchTextChange("${it.country}, ${it.city}")
                                        }
                                ) {
                                    AsyncImage(
                                        model = it.image,
                                        contentDescription = "${it.country} ${it.city}",
                                        contentScale = ContentScale.Crop
                                    )
                                    Text(
                                        text = "${it.country}, ${it.city}",
                                        fontSize = 13.sp,
                                        fontWeight = FontWeight.Black,
                                        modifier = Modifier
                                            .align(Alignment.BottomStart)
                                            .padding(12.dp),
                                        color = Color.White
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
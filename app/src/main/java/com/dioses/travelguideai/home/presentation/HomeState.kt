package com.dioses.travelguideai.home.presentation

import com.dioses.travelguideai.home.domain.model.HomeFilterSettings
import com.dioses.travelguideai.home.domain.model.Place
import com.dioses.travelguideai.home.domain.model.Region

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation
 * Created by Arthur Dioses Reto on 11/04/24 at 10:38 AM
 * All rights reserved 2024.
 ****/
data class HomeState(
    val searchText: String = "",
    val showDialog: Boolean = false,
    val filterSettings: HomeFilterSettings = HomeFilterSettings(),
    val filterSettingsBackup: HomeFilterSettings = filterSettings,
    val chatReply: String? = null,
    val selectedRegion: Region = Region.TODAS,
    val popularPlaces: List<Place> = emptyList(),
    val popularPlacesBackup: List<Place> = popularPlaces,
)

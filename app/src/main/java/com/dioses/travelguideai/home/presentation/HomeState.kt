package com.dioses.travelguideai.home.presentation

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
)

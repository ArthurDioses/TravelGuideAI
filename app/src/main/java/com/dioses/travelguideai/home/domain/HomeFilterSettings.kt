package com.dioses.travelguideai.home.domain

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation
 * Created by Arthur Dioses Reto on 12/04/24 at 1:45 AM
 * All rights reserved 2024.
 ****/
data class HomeFilterSettings(
    val people: Int = 1,
    val restaurant: Boolean = false,
    val museums: Boolean = false,
)

package com.dioses.travelguideai.home.presentation

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation
 * Created by Arthur Dioses Reto on 12/04/24 at 1:52 AM
 * All rights reserved 2024.
 ****/
sealed interface HomeFilterDialogAction {
    object OnApplyClick : HomeFilterDialogAction
    object OnRestaurantClick : HomeFilterDialogAction
    object OnMuseumClick : HomeFilterDialogAction
    object OnPeoplePlus : HomeFilterDialogAction
    object OnPeopleMinus : HomeFilterDialogAction
}
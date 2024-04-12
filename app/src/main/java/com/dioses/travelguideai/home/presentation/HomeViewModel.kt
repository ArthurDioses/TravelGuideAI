package com.dioses.travelguideai.home.presentation

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dioses.travelguideai.home.domain.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.presentation
 * Created by Arthur Dioses Reto on 10/04/24 at 10:22 PM
 * All rights reserved 2024.
 ****/

@HiltViewModel
class HomeViewModel @Inject constructor(private val repository: HomeRepository) : ViewModel() {
    var state by mutableStateOf(HomeState())
        private set

    fun onSearchTextChange(newText: String) {
        state = state.copy(searchText = newText)
    }

    fun onFilterClick() {
        state = state.copy(showDialog = true)
    }

    fun onFilterDismiss() {
        state = state.copy(showDialog = false, filterSettings = state.filterSettingsBackup)
    }

    fun onSettingsChange(action: HomeFilterDialogAction) {
        when (action) {
            HomeFilterDialogAction.OnApplyClick -> {
                state = state.copy(filterSettingsBackup = state.filterSettings, showDialog = false)
            }

            HomeFilterDialogAction.OnMuseumClick -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        museums = !state.filterSettings.museums
                    )
                )
            }

            HomeFilterDialogAction.OnPeopleMinus -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        people = state.filterSettings.people - 1
                    )
                )
            }

            HomeFilterDialogAction.OnPeoplePlus -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        people = state.filterSettings.people + 1
                    )
                )
            }

            HomeFilterDialogAction.OnRestaurantClick -> {
                state = state.copy(
                    filterSettings = state.filterSettings.copy(
                        restaurant = !state.filterSettings.restaurant
                    )
                )
            }
        }
    }

    fun search() {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText, state.filterSettings).onSuccess {
                println(it)
            }.onFailure { println("Hubo un error ${it.message}") }
        }
    }
}
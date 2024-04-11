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


    init {
    }

    fun onSearchTextChange(newText: String) {
        state = state.copy(searchText = newText)
    }

    fun search() {
        viewModelScope.launch {
            repository.getTravelGuide(state.searchText).onSuccess {
                println(it)
            }.onFailure { println("Hubo un error ${it.message}") }
        }
    }
}
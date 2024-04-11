package com.dioses.travelguideai.home.presentation

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
    init {
        viewModelScope.launch {
            repository.getTravelGuide().onSuccess {
                println(it)
            }.onFailure { println("Hubo un error ${it.message}") }
        }
    }
}
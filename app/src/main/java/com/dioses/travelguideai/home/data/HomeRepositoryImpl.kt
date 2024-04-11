package com.dioses.travelguideai.home.data

import com.dioses.travelguideai.home.data.remote.ChatGptApi
import com.dioses.travelguideai.home.data.remote.dto.ChatRequestDto
import com.dioses.travelguideai.home.domain.HomeRepository

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.data
 * Created by Arthur Dioses Reto on 11/04/24 at 12:13 AM
 * All rights reserved 2024.
 ****/
class HomeRepositoryImpl(
    private val api: ChatGptApi,
) : HomeRepository {
    override suspend fun getTravelGuide(location: String): Result<String> {
        return try {
            val request = ChatRequestDto(
                maxTokens = 0,
                model = "davinci-002",
                prompt = "Sos una guía de viaje. Te voy a dar mi ubicación, y me vas a sugerir lugares para visitar cerca. También te voy a dar los tipo de lugares que quiero visitar. Aparte, quiero que me sugieras lugares de un tipo similar a los que te mencione que estén cerca de mi primera ubicación. Estoy en $location y quiero visitar: Museos, Restaurantes. Dame los precios de cada lugar en USD. Ordenarlos por tipo de lugar.",
                temperature = 7
            )
            val information = api.getTravelInformation(request)
            Result.success(information.choices.first().text)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
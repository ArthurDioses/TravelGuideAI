package com.dioses.travelguideai.home.data

import com.dioses.travelguideai.home.data.remote.ChatGptApi
import com.dioses.travelguideai.home.data.remote.dto.ChatRequestDto
import com.dioses.travelguideai.home.domain.model.HomeFilterSettings
import com.dioses.travelguideai.home.domain.HomeRepository
import com.dioses.travelguideai.home.domain.model.Place
import com.dioses.travelguideai.home.domain.model.Region

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.data
 * Created by Arthur Dioses Reto on 11/04/24 at 12:13 AM
 * All rights reserved 2024.
 ****/
class HomeRepositoryImpl(
    private val api: ChatGptApi,
) : HomeRepository {
    override suspend fun getTravelGuide(
        location: String,
        settings: HomeFilterSettings,
    ): Result<String> {
        return try {
            var places = ""
            if (settings.restaurant) places += "Restaurantes, "
            if (settings.museums) places += "Museos, "

            val placesToVisit = if (places.isNotEmpty()) "y quiero visitar: $places" else ""

            val request = ChatRequestDto(
                maxTokens = 0,
                model = "davinci-002",
                prompt = "Sos una guía de viaje. Te voy a dar mi ubicación, y me vas a sugerir lugares para visitar cerca. También te voy a dar los tipo de lugares que quiero visitar. Aparte, quiero que me sugieras lugares de un tipo similar a los que te mencione que estén cerca de mi primera ubicación. Estoy en $location $placesToVisit. Solo quiero los precios de cada lugar en USD. Ordenarlos por tipo de lugar. No repitas los lugares.",
                temperature = 7
            )
            val information = api.getTravelInformation(request)
            Result.success(information.choices.first().text)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    override suspend fun getPopularPlaces(): Result<List<Place>> {
        return Result.success(
            listOf(
                Place("USA", "New York", Region.AMERICA),
                Place("Argentina", "Salta", Region.AMERICA),
                Place("España", "Barcelona", Region.EUROPA),
                Place("Australia", "Sydney", Region.OCEANIA),
                Place("Japon", "Tokio", Region.ASIA),
                Place("Italia", "Roma", Region.EUROPA),
            )
        )
    }
}
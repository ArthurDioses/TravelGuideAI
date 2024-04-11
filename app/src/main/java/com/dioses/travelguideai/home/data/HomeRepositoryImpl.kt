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
    override suspend fun getTravelGuide(): Result<String> {
        return try {
            val request = ChatRequestDto(
                maxTokens = 0,
                model = "davinci-002",
                prompt = "Say this is a test",
                temperature = 7
            )
            val information = api.getTravelInformation(request)
            Result.success(information.choices.first().text)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}
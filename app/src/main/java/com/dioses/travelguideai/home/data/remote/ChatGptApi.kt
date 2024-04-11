package com.dioses.travelguideai.home.data.remote

import com.dioses.travelguideai.home.data.remote.dto.ChatRequestDto
import com.dioses.travelguideai.home.data.remote.dto.ChatResponseDto
import retrofit2.http.Body
import retrofit2.http.POST

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.data.remote
 * Created by Arthur Dioses Reto on 10/04/24 at 11:10 PM
 * All rights reserved 2024.
 ****/
interface ChatGptApi {
    companion object {
        const val BASE_URL = "https://api.openai.com/v1/"
    }

    @POST("completions")
    suspend fun getTravelInformation(@Body body: ChatRequestDto): ChatResponseDto
}
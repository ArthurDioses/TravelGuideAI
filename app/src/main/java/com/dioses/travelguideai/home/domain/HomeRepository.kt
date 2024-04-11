package com.dioses.travelguideai.home.domain

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.domain
 * Created by Arthur Dioses Reto on 11/04/24 at 12:12 AM
 * All rights reserved 2024.
 ****/
interface HomeRepository {
    suspend fun getTravelGuide(location: String): Result<String>
}
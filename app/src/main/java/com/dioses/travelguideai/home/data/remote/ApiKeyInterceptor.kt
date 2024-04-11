package com.dioses.travelguideai.home.data.remote

import com.dioses.travelguideai.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.data.remote
 * Created by Arthur Dioses Reto on 11/04/24 at 12:30 AM
 * All rights reserved 2024.
 ****/
class ApiKeyInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
        request.addHeader("Authorization", "Bearer ${BuildConfig.API_KEY}")
        return chain.proceed(request.build())
    }
}
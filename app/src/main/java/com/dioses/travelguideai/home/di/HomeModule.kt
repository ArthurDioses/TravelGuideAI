package com.dioses.travelguideai.home.di

import com.dioses.travelguideai.home.data.HomeRepositoryImpl
import com.dioses.travelguideai.home.data.remote.ApiKeyInterceptor
import com.dioses.travelguideai.home.data.remote.ChatGptApi
import com.dioses.travelguideai.home.domain.HomeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

/****
 * Project: TravelGuideAI
 * From: com.dioses.travelguideai.home.di
 * Created by Arthur Dioses Reto on 10/04/24 at 11:51 PM
 * All rights reserved 2024.
 ****/
@InstallIn(SingletonComponent::class)
@Module
object HomeModule {
    @Provides
    @Singleton
    fun provideApi(): ChatGptApi {
        return Retrofit.Builder().baseUrl(ChatGptApi.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .client(
                OkHttpClient.Builder()
                    .connectTimeout(20, TimeUnit.SECONDS)
                    .readTimeout(20, TimeUnit.SECONDS)
                    .writeTimeout(20, TimeUnit.SECONDS)
                    .addInterceptor(HttpLoggingInterceptor())
                    .addInterceptor(ApiKeyInterceptor())
                    .build()
            ).build()
            .create()
    }

    @Provides
    @Singleton
    fun provideRepository(api: ChatGptApi): HomeRepository {
        return HomeRepositoryImpl(api)
    }
}
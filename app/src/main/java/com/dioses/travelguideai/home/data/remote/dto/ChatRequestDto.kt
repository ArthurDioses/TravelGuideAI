package com.dioses.travelguideai.home.data.remote.dto

import com.squareup.moshi.Json

data class ChatRequestDto(
    @field:Json(name = "messages")
    val messages: List<Message>,
    @field:Json(name = "model")
    val model: String,
)
package com.dioses.travelguideai.home.data.remote.dto

import com.squareup.moshi.Json

data class Choice(
    @field:Json(name = "finish_reason")
    val finishReason: String,
    @field:Json(name = "index")
    val index: Int,
    @field:Json(name = "logprobs")
    val logprobs: Any,
    @field:Json(name = "message")
    val message: Message,
)
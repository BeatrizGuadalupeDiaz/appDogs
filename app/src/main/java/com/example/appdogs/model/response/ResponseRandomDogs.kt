package com.example.appdogs.model.response

import com.google.gson.annotations.SerializedName

data class ResponseRandomDogs (
    @SerializedName("message")
    val data: String,
    @SerializedName("status")
    val status: String
)
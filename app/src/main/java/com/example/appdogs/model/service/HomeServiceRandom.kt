package com.example.appdogs.model.service

import com.example.appdogs.model.response.ResponseRandomDogs
import retrofit2.Response
import retrofit2.http.GET

interface HomeServiceRandom {
    //get ramdom image
    @GET("breeds/image/random")
    suspend fun getImageRandomDogs(): Response<ResponseRandomDogs>

}
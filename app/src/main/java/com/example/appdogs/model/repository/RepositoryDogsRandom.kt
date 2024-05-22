package com.example.appdogs.model.repository

import com.example.appdogs.model.datasource.DataSourceDogsRandom
import com.example.appdogs.model.response.ResponseRandomDogs
import retrofit2.Response

class RepositoryDogsRandom(private val dataSourceDogsRandom: DataSourceDogsRandom = DataSourceDogsRandom()) {
    suspend fun getImageDogs(): Response<ResponseRandomDogs> {
        return dataSourceDogsRandom.getImageRandom()
    }
}

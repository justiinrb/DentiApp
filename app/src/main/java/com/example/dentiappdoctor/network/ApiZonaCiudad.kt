package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.model.MZona_Ciudad.ZonaCiudadResponse
import com.example.dentiappdoctor.model.MZona_Ciudad.postZonaCiudad
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiZonaCiudad {

    @Headers("Content-Type:application/json")
    @POST("obtiene")
    suspend fun pushPostZona(
        @Body postZonaCiudad: postZonaCiudad
    ): Response<ZonaCiudadResponse>
}
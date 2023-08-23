package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.model.ModelSectorC.SectorResponse
import com.example.dentiappdoctor.model.ModelSectorC.postSectorC
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiSectorCiudad {
    @Headers("Content-Type:application/json")
    @POST("obtiene")

    suspend fun pushPostSect(
        @Body postSectorC: postSectorC
    ):Response<SectorResponse>
}
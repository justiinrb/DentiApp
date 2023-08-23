package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.model.ModInactivosOP.PostInactivosOP
import com.example.dentiappdoctor.model.ModInactivosOP.ResponseInactivosOP
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface API_InactivosOP {

    @Headers("Content-Type:application/json")
    @POST("inactivos")
    suspend fun pushPostInactivosOP(
        @Body postInactivosOP: PostInactivosOP
    ):Response<ResponseInactivosOP>

}
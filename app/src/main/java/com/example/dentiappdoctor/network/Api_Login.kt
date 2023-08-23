package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.model.ModelAccess.SesionPost
import com.example.dentiappdoctor.model.ModelAccess.logModel
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api_Login {
    @Headers("Content-Type:application/json")
    @POST("login")
    suspend fun pushPostLogin(
      @Body sesionPost: SesionPost
    ):Response<logModel>

}
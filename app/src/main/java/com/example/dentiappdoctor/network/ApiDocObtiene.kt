package com.example.dentiappdoctor.network


import com.example.dentiappdoctor.model.MdoctorObtiene.DocResponse
import com.example.dentiappdoctor.model.MdoctorObtiene.postDoc
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface ApiDocObtiene {
    @Headers("Content-Type:application/json")
    @POST("obtiene")

    suspend fun pushPostGetD(
        @Body postDoc: postDoc
    ):Response<DocResponse>
}
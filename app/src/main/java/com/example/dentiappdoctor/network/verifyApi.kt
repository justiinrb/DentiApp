package com.example.dentiappdoctor.network


import com.example.dentiappdoctor.model.Model_Conf_Login.verifyPost
import com.example.dentiappdoctor.model.Model_Conf_Login.verifyResponse
import retrofit2.Response
import retrofit2.http.Body

import retrofit2.http.POST

interface verifyApi {


    @POST("confirma_login")
    suspend fun pushPostVerify(
        @Body verifyPost: verifyPost
    ): Response<verifyResponse>
}
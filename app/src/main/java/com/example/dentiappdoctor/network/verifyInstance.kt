package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object verifyInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiVerify:verifyApi by lazy {
        retrofit.create(verifyApi::class.java)
    }

}
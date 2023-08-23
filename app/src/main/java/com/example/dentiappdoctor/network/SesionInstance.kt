package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object SesionInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(Const.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    val apiLogin:Api_Login by lazy {
        retrofit.create(Api_Login::class.java)
    }


}






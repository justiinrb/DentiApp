package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object InactivosOPInstance {
    private val retrofit by lazy {
        Retrofit.Builder().client(getClientes())
            .baseUrl(Const.URL_INACTIVOSOP)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeaderDocObtiene())
            .build()
        return cliente
    }

    val apiInactivosOP: API_InactivosOP by lazy {
        retrofit.create(API_InactivosOP::class.java)
    }

}
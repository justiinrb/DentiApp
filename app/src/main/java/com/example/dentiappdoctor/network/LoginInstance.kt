package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Constant
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object LoginInstance {
    // retrofit instance object class
    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClientes())
            .baseUrl(Constant.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeadersInterceptor())
            .build()
        return cliente
    }

    val apiLog: ApiLogin by lazy {
        retrofit.create(ApiLogin::class.java)
    }
}
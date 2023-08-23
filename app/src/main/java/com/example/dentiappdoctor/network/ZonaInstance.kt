package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object ZonaInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClientes())
            .baseUrl(Const.URL_ZONA)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeaderDocObtiene())
            .build()
        return cliente
    }

    val apiZonaCiudad : ApiZonaCiudad by lazy {
        retrofit.create(ApiZonaCiudad::class.java)
    }
}
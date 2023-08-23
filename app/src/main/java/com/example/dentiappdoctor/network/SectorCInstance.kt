package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object SectorCInstance {
    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClientes())
            .baseUrl(Const.URL_SEC)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeaderDocObtiene())
            .build()
        return cliente
    }

    val apiSector : ApiSectorCiudad by lazy {
        retrofit.create(ApiSectorCiudad::class.java)
    }

}
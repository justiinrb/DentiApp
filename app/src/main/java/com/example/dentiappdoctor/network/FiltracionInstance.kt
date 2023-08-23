package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.constant.Const
import com.example.dentiappdoctor.model.MBusquedaFiltrada.FiltracionResponse
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object FiltracionInstance {

    private val retrofit by lazy {
        Retrofit.Builder()
            .client(getClientes())
            .baseUrl(Const.URL_FILTRACION)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
    private fun getClientes(): OkHttpClient {
        val cliente = OkHttpClient.Builder()
            .addInterceptor(HeaderDocObtiene())
            .build()
        return cliente
    }

    val apiFil: Api_Filtracion by lazy {
        retrofit.create(Api_Filtracion ::class.java)
    }

}
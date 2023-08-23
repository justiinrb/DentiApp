package com.example.dentiappdoctor.network

import com.example.dentiappdoctor.model.MBusquedaFiltrada.FiltracionResponse
import com.example.dentiappdoctor.model.MBusquedaFiltrada.postFiltracion
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface Api_Filtracion {
    @Headers("Content-Type:application/json")
    @POST("busqueda_filtrada_pagineo")

    suspend fun pushPostFiltracion(
        @Body postFiltracion :postFiltracion
    ):Response<FiltracionResponse>
}
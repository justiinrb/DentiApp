package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class ContentFiltracion(
    @SerializedName("items_gral")
    val itemsGral: Int,
    @SerializedName("items_x_pagina")
    val itemsXPagina: Int,
    @SerializedName("ordenes")
    val ordenes: List<OrdenesFiltracion>,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("paginas")
    val paginas: Int
)
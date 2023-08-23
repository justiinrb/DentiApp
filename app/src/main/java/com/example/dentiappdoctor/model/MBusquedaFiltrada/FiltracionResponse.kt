package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class FiltracionResponse(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val contentFiltracion: ContentFiltracion,
    @SerializedName("mensaje")
    val mensaje: String
)
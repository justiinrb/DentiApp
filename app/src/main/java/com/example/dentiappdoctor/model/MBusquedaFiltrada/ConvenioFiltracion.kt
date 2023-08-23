package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class ConvenioFiltracion(
    @SerializedName("cantidad")
    val cantidad: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: Int
)
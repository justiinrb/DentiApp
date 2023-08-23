package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class CategoriaFiltreacion(
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("servicios")
    val servicios: List<ServicioFiltracion>
)
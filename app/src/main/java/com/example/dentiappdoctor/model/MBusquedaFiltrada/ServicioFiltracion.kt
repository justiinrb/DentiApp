package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class ServicioFiltracion(
    @SerializedName("codigo")
    val codigo: String,
    @SerializedName("comision")
    val comision: String,
    @SerializedName("comision_global")
    val comisionGlobal: Boolean,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("subtitulo")
    val subtitulo: String,
    @SerializedName("sucursales")
    val sucursales: List<SucursaleFiltracion>
)
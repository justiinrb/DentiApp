package com.example.dentiappdoctor.model.MBusquedaFiltrada


import com.google.gson.annotations.SerializedName

data class SucursaleFiltracion(
    @SerializedName("comision")
    val comision: String,
    @SerializedName("id_sucursal")
    val idSucursal: Int,
    @SerializedName("nombre_sucursal")
    val nombreSucursal: String,
    @SerializedName("pvp")
    val pvp: String,
    @SerializedName("referencia_sucursal")
    val referenciaSucursal: String
)
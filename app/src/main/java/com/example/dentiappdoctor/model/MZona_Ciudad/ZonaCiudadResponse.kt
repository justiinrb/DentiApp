package com.example.dentiappdoctor.model.MZona_Ciudad


import com.google.gson.annotations.SerializedName

data class ZonaCiudadResponse(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val contentZonaCiudad: List<ContentZonaCiudad>,
    @SerializedName("mensaje")
    val mensaje: String
)
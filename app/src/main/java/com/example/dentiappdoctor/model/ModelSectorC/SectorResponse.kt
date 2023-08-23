package com.example.dentiappdoctor.model.ModelSectorC


import com.google.gson.annotations.SerializedName

data class SectorResponse(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val contentSectorCiudad: List<ContentSectorCiudad>,
    @SerializedName("mensaje")
    val mensaje: String
)
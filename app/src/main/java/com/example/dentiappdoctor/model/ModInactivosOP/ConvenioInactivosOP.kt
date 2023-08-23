package com.example.dentiappdoctor.model.ModInactivosOP


import com.google.gson.annotations.SerializedName

data class ConvenioInactivosOP(
    @SerializedName("cantidad")
    val cantidad: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: Int
)
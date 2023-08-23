package com.example.dentiappdoctor.model.ModInactivosOP


import com.google.gson.annotations.SerializedName

data class ContentInactivosOP(
    @SerializedName("doctores")
    val doctoresInactivosOPS: List<DoctoresInactivosOP>,
    @SerializedName("items_gral")
    val itemsGral: Int,
    @SerializedName("items_x_pagina")
    val itemsXPagina: Int,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("paginas")
    val paginas: Int
)
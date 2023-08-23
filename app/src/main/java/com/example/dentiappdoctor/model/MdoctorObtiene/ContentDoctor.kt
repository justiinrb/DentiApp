package com.example.dentiappdoctor.model.MdoctorObtiene


import com.google.gson.annotations.SerializedName

data class ContentDoctor(
    @SerializedName("doctores")
    val doctoresActivos: List<DoctoresActivos>,
    @SerializedName("items_gral")
    val itemsGral: Int,
    @SerializedName("items_x_pagina")
    val itemsXPagina: Int,
    @SerializedName("pagina")
    val pagina: Int,
    @SerializedName("paginas")
    val paginas: Int
)
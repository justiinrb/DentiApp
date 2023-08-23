package com.example.dentiappdoctor.model.MdoctorObtiene


import com.google.gson.annotations.SerializedName

data class Convenio(
    @SerializedName("cantidad")
    val cantidad: Int,
    @SerializedName("descripcion")
    val descripcion: String,
    @SerializedName("id")
    val id: Int
)
package com.example.dentiappdoctor.model.Model_Conf_Login


import com.google.gson.annotations.SerializedName

data class Sucursale(
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("referencia")
    val referencia: String
)
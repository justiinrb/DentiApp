package com.example.dentiappdoctor.model.Model_Conf_Login


import com.google.gson.annotations.SerializedName

data class DoctorSucursal(
    @SerializedName("apellidos")
    val apellidos: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombres")
    val nombres: String
)
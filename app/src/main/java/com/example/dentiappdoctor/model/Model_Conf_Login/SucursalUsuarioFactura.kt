package com.example.dentiappdoctor.model.Model_Conf_Login


import com.google.gson.annotations.SerializedName

data class SucursalUsuarioFactura(
    @SerializedName("apellido")
    val apellido: String,
    @SerializedName("codigo_empleado")
    val codigoEmpleado: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("rol")
    val rol: String
)
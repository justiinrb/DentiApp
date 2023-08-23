package com.example.dentiappdoctor.model.MdoctorObtiene


import com.google.gson.annotations.SerializedName

data class DoctoresActivos(
    @SerializedName("apellido")
    val apellido: String,
    @SerializedName("celular")
    val celular: String,
    @SerializedName("correo")
    val correo: String,
    @SerializedName("direccion")
    val direccion: String,
    @SerializedName("genero_descripcion")
    val generoDescripcion: String,
    @SerializedName("genero_id")
    val generoId: Int,
    @SerializedName("id")
    val id: Int,
    @SerializedName("identificacion")
    val identificacion: String,
    @SerializedName("nombre")
    val nombre: String,
    @SerializedName("sector_descripcion")
    val sectorDescripcion: String,
    @SerializedName("sector_id")
    val sectorId: Int,
    @SerializedName("status")
    val status: Boolean,
    @SerializedName("tipo_identificacion")
    val tipoIdentificacion: String,
    @SerializedName("zona_descripcion")
    val zonaDescripcion: String,
    @SerializedName("zona_id")
    val zonaId: Int
)
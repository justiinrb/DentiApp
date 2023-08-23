package com.example.dentiappdoctor.model.MdoctorObtiene


import com.google.gson.annotations.SerializedName

data class DocResponse(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val contentDoctor: ContentDoctor,
    @SerializedName("mensaje")
    val mensaje: String
)
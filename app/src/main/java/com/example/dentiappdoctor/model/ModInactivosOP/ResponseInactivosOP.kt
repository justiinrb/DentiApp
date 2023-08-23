package com.example.dentiappdoctor.model.ModInactivosOP


import com.google.gson.annotations.SerializedName

data class ResponseInactivosOP(
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val contentInactivosOP: ContentInactivosOP,
    @SerializedName("mensaje")
    val mensaje: String
)
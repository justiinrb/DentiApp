package com.example.dentiappdoctor.model.Model_Conf_Login



import com.google.gson.annotations.SerializedName



data class verifyResponse(
    @SerializedName("mensaje")
    val mensaje: String,
    @SerializedName("codigo")
    val codigo: Int,
    @SerializedName("content")
    val content: ContentVerify,

    )
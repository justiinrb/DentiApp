package com.example.dentiappdoctor.model.fintradeM

data class ContentF(

    val usuarioid: String,
    val correo: String,
    val id_role: String,
    val cantd_clients: String,
    val id_broker: String,
    val nombre: String,
    val version: String,
    val build: String,
    val platform: String,
    val clientid: ArrayList<Clientid>,
    val empresas: ArrayList<Empresas>
)
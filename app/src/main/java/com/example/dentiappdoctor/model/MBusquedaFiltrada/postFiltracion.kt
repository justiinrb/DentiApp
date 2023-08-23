package com.example.dentiappdoctor.model.MBusquedaFiltrada

data class postFiltracion (
    val zona_id : Int,
    val sector_id : Int,
    val nombre : String,
    val identificacion :String,
    val items : Int,
    val pagina : Int
        )

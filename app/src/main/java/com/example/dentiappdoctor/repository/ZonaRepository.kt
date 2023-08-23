package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.MZona_Ciudad.ZonaCiudadResponse
import com.example.dentiappdoctor.model.MZona_Ciudad.postZonaCiudad
import com.example.dentiappdoctor.network.ZonaInstance

class ZonaRepository {

    suspend fun zonaRepo(catalogo:String):ZonaCiudadResponse?{
        val request = postZonaCiudad(catalogo)

        val responseRepo = ZonaInstance.apiZonaCiudad.pushPostZona(request)
        return if(responseRepo.isSuccessful){
            responseRepo.body()
        }else{
            null
        }
    }
}
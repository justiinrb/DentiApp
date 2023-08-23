package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.MBusquedaFiltrada.FiltracionResponse
import com.example.dentiappdoctor.model.MBusquedaFiltrada.postFiltracion
import com.example.dentiappdoctor.network.FiltracionInstance

class FiltracionRepository {

    suspend fun repoFiltracion(zona_id : Int,sector_id:Int, nombre : String,identificacion:String,items : Int,pagina:Int):FiltracionResponse?{
        val request = postFiltracion(zona_id,sector_id, nombre, identificacion, items, pagina)
        val responseRepo = FiltracionInstance.apiFil.pushPostFiltracion(request)
        return if (responseRepo.isSuccessful){
            responseRepo.body()
        }else{
            null
        }

    }
}
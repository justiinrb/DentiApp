package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.ModelSectorC.SectorResponse
import com.example.dentiappdoctor.model.ModelSectorC.postSectorC
import com.example.dentiappdoctor.network.SectorCInstance

class SectorCRepository {

    suspend fun SectorRepo(catalogo:String):SectorResponse?{
        val request = postSectorC(catalogo)
        val responseRepos = SectorCInstance.apiSector.pushPostSect(request)

        return if(responseRepos.isSuccessful){
            responseRepos.body()
        }else{
            null
        }
    }
}
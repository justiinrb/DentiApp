package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.ModInactivosOP.PostInactivosOP
import com.example.dentiappdoctor.model.ModInactivosOP.ResponseInactivosOP
import com.example.dentiappdoctor.network.InactivosOPInstance

class InactivosOPRepository {
    suspend fun repoInactivosOP(inicio:String, fin: String, items:Int,pagina:Int):ResponseInactivosOP?{
        val request = PostInactivosOP(inicio,fin,items, pagina)
        val responseRepo = InactivosOPInstance.apiInactivosOP.pushPostInactivosOP(request)
        return if (responseRepo.isSuccessful){
            responseRepo.body()
        }else{
            null
        }
    }
}
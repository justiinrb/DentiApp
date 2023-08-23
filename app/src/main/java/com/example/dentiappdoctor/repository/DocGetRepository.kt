package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.MdoctorObtiene.DocResponse
import com.example.dentiappdoctor.model.MdoctorObtiene.postDoc
import com.example.dentiappdoctor.network.DocObInstance

class DocGetRepository {
    suspend fun repGetDoc(items:Int,pagina:Int):DocResponse?{
        val request = postDoc(items,pagina)
        val responseRep = DocObInstance.apiGetDoc.pushPostGetD(request)
        return if(responseRep.isSuccessful){
            responseRep.body()
        }else{
            null
        }
    }
}
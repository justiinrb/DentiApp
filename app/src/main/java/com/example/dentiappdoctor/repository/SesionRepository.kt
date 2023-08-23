package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.ModelAccess.SesionPost
import com.example.dentiappdoctor.model.ModelAccess.logModel
import com.example.dentiappdoctor.network.SesionInstance

class SesionRepository {
    suspend fun loginR(correo :String): logModel?{
        val request = SesionPost(correo)
        val responseR = SesionInstance.apiLogin.pushPostLogin(request)
        return if(responseR.isSuccessful){
            responseR.body()
        }else{
            null
        }

    }


}
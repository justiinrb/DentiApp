package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.Model_Conf_Login.verifyPost
import com.example.dentiappdoctor.model.Model_Conf_Login.verifyResponse
import com.example.dentiappdoctor.network.verifyInstance

class verifyRepository {

    suspend fun repVerf(correo:String,clave:String): verifyResponse?{
        val request = verifyPost(correo, clave)
        val responseRep = verifyInstance.apiVerify.pushPostVerify(request)
        return if (responseRep.isSuccessful){
            responseRep.body()
        }else{
            null
        }
    }
}
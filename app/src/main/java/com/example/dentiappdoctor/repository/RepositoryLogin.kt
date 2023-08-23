package com.example.dentiappdoctor.repository

import com.example.dentiappdoctor.model.fintradeM.PostLogin
import com.example.dentiappdoctor.network.LoginInstance
import okhttp3.ResponseBody
import retrofit2.Response

class RepositoryLogin {
    suspend fun pshPotsLogin(
        postLog : PostLogin
    ): Response<ResponseBody> {
        return LoginInstance.apiLog.pushPostLogin(
            postLog.username,
            postLog.password,
            postLog.platform,
            postLog.version,
            postLog.build,
            postLog.modelDevice,
            postLog.nameDevice,
            postLog.versionSystem,
            postLog.tokendevice
        )
    }
}
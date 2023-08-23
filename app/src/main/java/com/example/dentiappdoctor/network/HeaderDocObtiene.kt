package com.example.dentiappdoctor.network

import okhttp3.Interceptor
import okhttp3.Response

class HeaderDocObtiene :Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder()
            .addHeader("tokendental", "b8cda4b9bee54b21e684c1c4be53df3c")
            .build()
        return chain.proceed(request)

    }
}
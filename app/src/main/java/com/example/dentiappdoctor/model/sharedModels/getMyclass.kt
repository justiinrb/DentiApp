package com.example.dentiappdoctor.model.sharedModels

import android.content.Context
import android.content.SharedPreferences
import com.example.dentiappdoctor.model.Model_Conf_Login.ContentVerify
import com.google.gson.Gson

class getMyclass {
    fun getSharedContent(context: Context): ContentVerify? {
        val sharedPreferences: SharedPreferences =
            context.getSharedPreferences("Myprefs", Context.MODE_PRIVATE)
        val gson = Gson()
        val json = sharedPreferences.getString("verifyMyclass", null)
        return gson.fromJson(json, ContentVerify::class.java)

    }
}
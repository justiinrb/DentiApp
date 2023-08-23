package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.Model_Conf_Login.verifyResponse
import com.example.dentiappdoctor.repository.verifyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class verifyViewModel(private val repoVerify:verifyRepository):ViewModel() {

    private val pushvMverify = MutableLiveData<verifyResponse?>()
    val resulVerify : LiveData<verifyResponse?> = pushvMverify

    fun verifyVm(correo:String,clave:String){
        viewModelScope.launch {
            pushvMverify.value = withContext(Dispatchers.IO){
                repoVerify.repVerf(correo,clave)
            }
        }
    }


    }

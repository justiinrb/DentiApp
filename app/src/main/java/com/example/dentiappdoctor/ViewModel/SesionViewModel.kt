package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.ModelAccess.logModel
import com.example.dentiappdoctor.repository.SesionRepository
import kotlinx.coroutines.Dispatchers

import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class SesionViewModel  (private val repositoryLogin: SesionRepository): ViewModel()  {

    private var pushVMlogin = MutableLiveData<logModel?>()
    val resultSesion:LiveData<logModel?> = pushVMlogin

    fun loginVM(correo:String) {
        viewModelScope.launch {
            pushVMlogin.value = withContext(Dispatchers.IO){
                repositoryLogin.loginR(correo)
            }
        }
    }


    }




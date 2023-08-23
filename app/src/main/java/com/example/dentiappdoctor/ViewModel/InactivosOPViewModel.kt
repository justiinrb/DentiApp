package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.ModInactivosOP.ResponseInactivosOP
import com.example.dentiappdoctor.repository.InactivosOPRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class InactivosOPViewModel(private val repositoryInactivosOP:InactivosOPRepository):ViewModel() {

    private val  pushVMInactivos = MutableLiveData<ResponseInactivosOP?>()
    val resultInactivos : LiveData<ResponseInactivosOP?> = pushVMInactivos

    fun InactivosOPVM(inicio:String,fin:String, items:Int,pagina:Int){
        viewModelScope.launch {
            pushVMInactivos.value = withContext(Dispatchers.IO){
                repositoryInactivosOP.repoInactivosOP(inicio, fin, items, pagina)
            }
        }
    }

}
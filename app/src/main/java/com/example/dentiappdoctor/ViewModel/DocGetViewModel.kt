package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.MdoctorObtiene.DocResponse
import com.example.dentiappdoctor.repository.DocGetRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class DocGetViewModel(private val repoDoct: DocGetRepository): ViewModel() {

    private val pushVMGetDoc = MutableLiveData<DocResponse?>()
    val resultGDoc: LiveData<DocResponse?> = pushVMGetDoc

    fun GetDocVM(items:Int,pagina:Int){
        viewModelScope.launch {
            pushVMGetDoc.value = withContext(Dispatchers.IO){
                repoDoct.repGetDoc(items, pagina)
            }
        }

    }
}
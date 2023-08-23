package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.ModelSectorC.SectorResponse
import com.example.dentiappdoctor.repository.SectorCRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SectorCViewModel(private val repoSector : SectorCRepository): ViewModel() {

    private val pushVMSector = MutableLiveData<SectorResponse?>()
    val resulSector : LiveData<SectorResponse?> = pushVMSector


    fun SectorVM(catalogo:String){
        viewModelScope.launch {
            pushVMSector.value = withContext(Dispatchers.IO){
                repoSector.SectorRepo(catalogo)
            }
        }

    }
}
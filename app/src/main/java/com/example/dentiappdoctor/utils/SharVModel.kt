package com.example.dentiappdoctor.utils

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.dentiappdoctor.model.MZona_Ciudad.ContentZonaCiudad
import com.example.dentiappdoctor.model.ModelSectorC.ContentSectorCiudad

class SharVModel : ViewModel(){
    val sectorCiudadList = MutableLiveData<List<ContentSectorCiudad>>()
    val zonaCiudadList = MutableLiveData<List<ContentZonaCiudad>>()

    // LiveData para el evento de mostrar la lista
    val showListEvent = MutableLiveData<Unit>()

    fun onShowListClick() {
        // Llama a este método cuando se presione el botón btnMostarLisDoc
        showListEvent.value = Unit
    }
}
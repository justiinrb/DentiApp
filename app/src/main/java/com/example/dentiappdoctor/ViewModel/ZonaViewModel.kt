package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.MZona_Ciudad.ZonaCiudadResponse
import com.example.dentiappdoctor.repository.ZonaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ZonaViewModel(val repozona:ZonaRepository):ViewModel() {

    private val pushVMZona = MutableLiveData<ZonaCiudadResponse?>()
    val resulVZona : LiveData<ZonaCiudadResponse?> = pushVMZona

    fun zonaVM(catalogo:String){
        viewModelScope.launch {
            pushVMZona.value = withContext(Dispatchers.IO){
                repozona.zonaRepo(catalogo)
            }

        }
    }
}
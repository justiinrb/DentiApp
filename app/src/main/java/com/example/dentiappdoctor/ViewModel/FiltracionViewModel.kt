package com.example.dentiappdoctor.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.dentiappdoctor.model.MBusquedaFiltrada.FiltracionResponse
import com.example.dentiappdoctor.repository.FiltracionRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class FiltracionViewModel(private val repository: FiltracionRepository): ViewModel() {


   private  val pushFiltracion = MutableLiveData<FiltracionResponse?>()

    val resultFiltracion : LiveData<FiltracionResponse?> = pushFiltracion

    fun filtracionVM(zona_id:Int, sector_id:Int, nombre:String,identificacion:String,items:Int,pagina:Int){
        viewModelScope.launch {
            pushFiltracion.value= withContext(Dispatchers.IO){
                repository.repoFiltracion(zona_id, sector_id, nombre, identificacion, items, pagina)
            }
        }
    }

}
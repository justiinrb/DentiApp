package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.dentiappdoctor.ViewModel.ZonaViewModel
import com.example.dentiappdoctor.repository.ZonaRepository


class ZonaVMFactory(private val repository: ZonaRepository):ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ZonaViewModel::class.java)) {
            return ZonaViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
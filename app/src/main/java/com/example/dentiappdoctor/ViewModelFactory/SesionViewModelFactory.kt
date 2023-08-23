package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.SesionViewModel
import com.example.dentiappdoctor.repository.SesionRepository

class SesionViewModelFactory(private val repositoryLogin: SesionRepository): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SesionViewModel::class.java)) {
            return SesionViewModel(repositoryLogin) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
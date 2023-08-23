package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.DocGetViewModel
import com.example.dentiappdoctor.ViewModel.SectorCViewModel
import com.example.dentiappdoctor.repository.DocGetRepository
import com.example.dentiappdoctor.repository.SectorCRepository

class SectorVMFactory(private val repositorySector: SectorCRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(SectorCViewModel::class.java)) {
            return SectorCViewModel(repositorySector) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
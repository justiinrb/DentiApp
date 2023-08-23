package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.FiltracionViewModel
import com.example.dentiappdoctor.ViewModel.InactivosOPViewModel
import com.example.dentiappdoctor.repository.FiltracionRepository

class FiltracionVMFactory(private val repository: FiltracionRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(FiltracionViewModel::class.java)) {
            return FiltracionViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
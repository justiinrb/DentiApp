package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.LoginViewModel
import com.example.dentiappdoctor.ViewModel.SesionViewModel
import com.example.dentiappdoctor.ViewModel.verifyViewModel
import com.example.dentiappdoctor.repository.verifyRepository

class verifyVMFactory(private val repository: verifyRepository):ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(verifyViewModel::class.java)) {
            return verifyViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }

}
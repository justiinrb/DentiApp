package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import com.example.dentiappdoctor.ViewModel.InactivosOPViewModel
import com.example.dentiappdoctor.repository.InactivosOPRepository

class InactivosOPVMFactory(private val factoryRepoInacOP : InactivosOPRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(InactivosOPViewModel::class.java)) {
            return InactivosOPViewModel(factoryRepoInacOP) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
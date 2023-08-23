package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.DocGetViewModel

import com.example.dentiappdoctor.repository.DocGetRepository


class GetDocVMFactory(private val repository: DocGetRepository): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        if (modelClass.isAssignableFrom(DocGetViewModel::class.java)) {
            return DocGetViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel Class")
    }
}
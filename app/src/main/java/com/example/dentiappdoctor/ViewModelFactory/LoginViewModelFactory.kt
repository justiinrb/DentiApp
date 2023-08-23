package com.example.dentiappdoctor.ViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.ViewModel.LoginViewModel
import com.example.dentiappdoctor.repository.RepositoryLogin

class LoginViewModelFactory (private val repositoryLogin: RepositoryLogin): ViewModelProvider.Factory {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LoginViewModel(repositoryLogin) as T
    }
}
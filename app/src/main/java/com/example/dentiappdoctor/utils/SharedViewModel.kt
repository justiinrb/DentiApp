package com.example.dentiappdoctor.utils

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedViewModel : ViewModel() {
    private val _buttonClicked = MutableLiveData<Unit>()

    val buttonClicked: LiveData<Unit>
        get() = _buttonClicked

    fun onButtonClick() {
        _buttonClicked.value = Unit
    }
}
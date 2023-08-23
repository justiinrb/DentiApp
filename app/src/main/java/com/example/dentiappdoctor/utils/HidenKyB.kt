package com.example.dentiappdoctor.utils

import android.content.Context
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity

class HidenKyB {
    fun hideKeyboard(activity: AppCompatActivity){
        val inputMethodManager = activity.getSystemService(Context.INPUT_METHOD_SERVICE)as InputMethodManager
        val currentFocusView = activity.currentFocus
        currentFocusView?.let {
            inputMethodManager.hideSoftInputFromWindow(it.windowToken, InputMethodManager.HIDE_NOT_ALWAYS)
        }
    }
}
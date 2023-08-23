package com.example.dentiappdoctor.utils

class ValidEmail {

    fun isValidEmail(email: String): Boolean {
        val emailRegex = Regex(pattern = "[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")
        return email.matches(emailRegex)
    }
}
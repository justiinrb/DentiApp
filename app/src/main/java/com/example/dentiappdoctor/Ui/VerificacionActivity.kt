package com.example.dentiappdoctor.Ui

import android.annotation.SuppressLint
import android.content.Context

import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button

import android.widget.TextView

import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.Observer
import androidx.navigation.ui.AppBarConfiguration
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.ViewModel.verifyViewModel
import com.example.dentiappdoctor.ViewModelFactory.verifyVMFactory
import com.example.dentiappdoctor.databinding.ActivityVerificacionBinding
import com.example.dentiappdoctor.model.Model_Conf_Login.ContentVerify
import com.example.dentiappdoctor.repository.verifyRepository
import com.example.dentiappdoctor.utils.HidenKyB
import com.google.gson.Gson


class VerificacionActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityVerificacionBinding
    private lateinit var hidenKyB: HidenKyB
    private lateinit var vModel: verifyViewModel
    private var email: String = ""

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityVerificacionBinding.inflate(layoutInflater)
        validConf()

        setContentView(binding.root)

        val button = findViewById<Button>(R.id.bton_verfy)
        email = intent.getStringExtra("CORREOM").toString()
        val textView = findViewById<TextView>(R.id.conf_correo).apply {
            text = email
        }

        vModel = verifyViewModel(verifyRepository())
        hidenKyB = HidenKyB()

        binding.linearVerfy.setOnClickListener {
            hidenKyB.hideKeyboard(this)
        }

        button.setOnClickListener {
            println("clickk " + button)
            if (binding.editPass.text.toString() != "") {
                val repositoryLogin = verifyRepository()
                val viewLoginFactory = verifyVMFactory(repositoryLogin)
                vModel = ViewModelProvider(this, viewLoginFactory).get(verifyViewModel::class.java)
                vModel.verifyVm(
                    email,
                    binding.editPass.text.toString()
                )
                vModel.resulVerify.observe(this, Observer { response ->

                    println("Responseee " + response?.codigo)

                    if (response?.codigo == 1) {
                        saveMyClass(this,response.content)
                        val i = Intent(this, MenuActivity::class.java)
                        startActivity(i)
                        finish()
                        println("succefull")
                    } else {
                        println("Errorr response " + response?.mensaje)
                    }
                })
            } else {
                println("Error")
            }
        }
    }
    fun saveMyClass(context: Context, myclass: ContentVerify){
        val sharedPreferences :SharedPreferences = context.getSharedPreferences("Myprefs",Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        val gson = Gson()
        val json  = gson.toJson(myclass)
        editor.putString("verifyMyclass",json)
        editor.apply()
    }
    @SuppressLint("UseCompatLoadingForDrawables")

    private fun validConf() {
        val invalidcolor = getColor(R.color.grey_)
        val validcolor = getColor(R.color.red)
        val invalidDrawable = getDrawable(R.drawable.radius_login)
        binding.btonVerfy.setTextColor(android.graphics.Color.WHITE)
        binding.btonVerfy.background = invalidDrawable
        binding.btonVerfy.backgroundTintList = ColorStateList.valueOf(invalidcolor)
        binding.editPass.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                val password = binding.editPass.text.toString()
                val colorsbton = if (passwordIsValid(password)) validcolor else invalidcolor
                binding.btonVerfy.backgroundTintList = ColorStateList.valueOf(colorsbton)
                val drawable =
                    if (passwordIsValid(password)) getDrawable(R.drawable.radiusred) else getDrawable(
                        R.drawable.radius_login
                    )
                binding.btonVerfy.background = drawable
            }
        })
    }

    private fun passwordIsValid(password: String): Boolean {
        // Implement your password validation logic h1ere
        // For example, check if it meets certain criteria like minimum length, contains uppercase letters, etc.
        // Return true if password is valid, false otherwise
        return password.length > 3 && password.matches(Regex(".*[0-9].*"))
    }


}
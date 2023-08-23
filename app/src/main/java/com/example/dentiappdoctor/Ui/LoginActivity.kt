package com.example.dentiappdoctor.Ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.ui.AppBarConfiguration
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.ViewModel.LoginViewModel
import com.example.dentiappdoctor.ViewModelFactory.LoginViewModelFactory
import com.example.dentiappdoctor.databinding.ActivityLoginBinding
import com.example.dentiappdoctor.model.fintradeM.PostLogin
import com.example.dentiappdoctor.model.fintradeM.ResponseLogin
import com.example.dentiappdoctor.repository.RepositoryLogin
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonParser

class   LoginActivity : AppCompatActivity() {
    private var progressBar: ProgressBar? = null
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityLoginBinding
    private lateinit var VModel: LoginViewModel
    lateinit var _youremail: EditText
    lateinit var _yourpassword: EditText
    lateinit var _logn: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        _youremail = findViewById(R.id.youremail)
        _yourpassword = findViewById(R.id.yourpassword)
        val button = findViewById<Button>(R.id.logn)
        VModel = LoginViewModel(RepositoryLogin())
        progressBar = findViewById<ProgressBar>(R.id.progress) as ProgressBar


        button.setOnClickListener {
            progressBar!!.visibility = View.VISIBLE


            println("validacion" + validate())
            if (validate()) {
                val repositoryLogin = RepositoryLogin()
                val viewLoginFactory = LoginViewModelFactory(repositoryLogin)
                VModel = ViewModelProvider(this, viewLoginFactory).get(LoginViewModel::class.java)
                // viewModel.getPosts()
                val postLogin = PostLogin(
                    _youremail.text.toString(),
                    _yourpassword.text.toString(),
                    "iOS",
                    "1.0.17",
                    "22",
                    "iPhone",
                    "iPhone 8",
                    "15.2",
                    "cfTKdvTY80Cyu0xei_FzJC:APA91bExC4a9T2dtfhUhm1CwR-H9CmNkzkLPPZF-l842UyyvsA6cJ7Pzj7tCOV21GpYP08TVXqA6qUbXjAYl6ekv0OxTpPHM9KqlPFHUI0H-tYd17sTHnf_SBlTtNy-CoKYKz2EOBZ3I"

                )

                VModel.shoveLogin(postLogin)
                VModel.pushrespLogin.observe(this, Observer { response ->
                    //result.text = response.toString()
                    progressBar!!.visibility = View.GONE



                    try {
                        val gsoon = GsonBuilder().setPrettyPrinting().create()
                        val prettyJson = gsoon.toJson(
                            JsonParser.parseString(
                                response.body()
                                    ?.string() // About this thread blocking annotation : https://github.com/square/retrofit/issues/3255
                            )

                        )

                        Log.d("Pretty Printed JSON :", prettyJson)
                        val gson = Gson()
                        val myClass = gson?.fromJson(prettyJson, ResponseLogin::class.java)
                        //val _myClass: ResponseLogin = Gson().fromJson(responseBody, ResponseLogin::class.java)
                        if (myClass?.error == true) {
                            println("hay un error")
                        } else {
                            val intent = Intent(this, VerificacionActivity::class.java)
                            startActivity(intent)
                            println("Succeful")
                        }
                        println("result: " + myClass?.error)
                    } catch (e: Exception) {
                        println("result-error: " + e.message)
                    }


                })
            }
        }

    }


    fun validate(): Boolean {
        if (_youremail.toString().length == 0) {
            Toast.makeText(this, "ingrese el usuario", Toast.LENGTH_SHORT).show()
            return false
        }
        if (_yourpassword.toString().length == 0) {
            Toast.makeText(this, "ingress la contraseña", Toast.LENGTH_SHORT).show()
            return false
        }
        return true



    }


}
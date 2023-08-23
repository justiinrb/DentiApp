package com.example.dentiappdoctor.Ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.ColorStateList
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.view.WindowCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dentiappdoctor.R
import com.example.dentiappdoctor.ViewModel.SesionViewModel
import com.example.dentiappdoctor.ViewModelFactory.SesionViewModelFactory

import com.example.dentiappdoctor.databinding.ActivitySesionBinding

import com.example.dentiappdoctor.repository.SesionRepository
import com.example.dentiappdoctor.utils.HidenKyB
import com.example.dentiappdoctor.utils.ValidEmail
import com.example.dentiappdoctor.utils.ValidNet


class SesionActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySesionBinding
    private lateinit var validNet: ValidNet
    private lateinit var validEmail: ValidEmail
    private lateinit var hidenKyB: HidenKyB
    private lateinit var VModel: SesionViewModel


    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreate(savedInstanceState: Bundle?) {

        setTheme(R.style.AppFullScreenTheme)

        WindowCompat.setDecorFitsSystemWindows(window, false)

        super.onCreate(savedInstanceState)

        binding = ActivitySesionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        VModel = SesionViewModel(SesionRepository())
        validNet = ValidNet()
        hidenKyB = HidenKyB()
        validEmail = ValidEmail()
        val btnV = findViewById<Button>(R.id.btn_logn)


        val invalidcolor = getColor(R.color.grey_)
        val validcolor = getColor(R.color.red)
        val invalidDrawable = getDrawable(R.drawable.radius_login)
        binding.btnLogn.setTextColor(android.graphics.Color.WHITE)
        binding.btnLogn.background = invalidDrawable
        binding.btnLogn.backgroundTintList = ColorStateList.valueOf(invalidcolor)


        binding.editEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                val isValidateEmail = validEmail.isValidEmail(s.toString())
                val button_c = if (isValidateEmail) validcolor else invalidcolor
                binding.btnLogn.backgroundTintList = ColorStateList.valueOf(button_c)
                val drawable =
                    if (isValidateEmail) getDrawable(R.drawable.radiusred) else getDrawable(R.drawable.radius_login)


                binding.btnLogn.background = drawable
                binding.btnLogn.isEnabled = !s.isNullOrEmpty() && isValidateEmail
            }
        })
        binding.Lnear.setOnClickListener {
            hidenKyB.hideKeyboard(this)
        }

        binding.btnLogn.setOnClickListener {
            callVerify()
            if (validNet.isInternetAvailable(this)) {
                val repositoryL = SesionRepository()
                val VmodelFactory = SesionViewModelFactory(repositoryL)
                VModel = ViewModelProvider(this, VmodelFactory).get(SesionViewModel::class.java)

                VModel.loginVM(binding.editEmail.text.toString())

                VModel.resultSesion.observe(this, Observer { response ->

                    println("codigoooo" + response?.codigo)


                    if (response?.codigo == 1) {
                        val intent = Intent(this, VerificacionActivity::class.java)
                        startActivity(intent)
                        println("Succeful")
                    } else {
                        println("Errorrrr " + response?.mensaje)
                    }

                })
            } else { Toast.makeText(baseContext, "No esta conectado a Internet ", Toast.LENGTH_SHORT).show() }
        }
    }
    private fun callVerify() {
        val editText = findViewById<EditText>(R.id.editEmail)
        val message = editText.text.toString()

        val intent = Intent(this, VerificacionActivity::class.java).also {
            it.putExtra("CORREOM", message)
            startActivity(it)
        }
    }


}







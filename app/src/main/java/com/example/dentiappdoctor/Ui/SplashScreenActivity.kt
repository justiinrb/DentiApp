package com.example.dentiappdoctor.Ui

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import com.example.dentiappdoctor.databinding.ActivitySplashScreenBinding
import com.example.dentiappdoctor.model.sharedModels.getMyclass

@SuppressLint("CustomSplashScreen")
class SplashScreenActivity : AppCompatActivity() {

    private lateinit var getMyclass : getMyclass
    private val SPLASH_DISPLAY_LENGTH = 2000

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)

        setContentView(binding.root)

        getMyclass = getMyclass()
        dataPass()



        }

    private fun dataPass(){
        if(getMyclass.getSharedContent(this) == null){
            Handler().postDelayed({
                val intent = Intent(this,SesionActivity::class.java)
                startActivity(intent)
                finish()
            },SPLASH_DISPLAY_LENGTH.toLong())
            println()
        }else{
            Handler().postDelayed({
                val intent = Intent(this,MenuActivity::class.java)
                startActivity(intent)
                finish()
            },SPLASH_DISPLAY_LENGTH.toLong())
        }

    }


    }


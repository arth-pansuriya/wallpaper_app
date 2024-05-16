package com.example.wallpaperapp

import android.app.ActivityOptions
import android.content.Intent
import android.content.SharedPreferences
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.util.Pair

class AnimateSplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val logo = findViewById<ImageView>(R.id.pinkLogo)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }
//
        setContentView(R.layout.activity_animate_splash)

        var sharedPref : SharedPreferences = this.getSharedPreferences("MCAPref", MODE_PRIVATE)

        Log.d("IS_LOGIN>>>>>>>>>>>>",sharedPref.getBoolean("IS_LOGIN",false).toString())

        Handler().postDelayed(Runnable {
            if(sharedPref.getBoolean("IS_LOGIN",false))
            {
                startActivity(Intent(this@AnimateSplashActivity,MainActivity::class.java))
            }else{
                startActivity(Intent(this@AnimateSplashActivity,LoginActivity::class.java))
            }

            finish()
        },2500)
    }
}
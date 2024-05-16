package com.example.wallpaperapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.Window
import android.view.WindowManager

class SplashScreenActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }

        setContentView(R.layout.activity_splash_screen)

        var sharedPref :  SharedPreferences = this.getSharedPreferences("MCAPref", MODE_PRIVATE)

        Log.d("IS_LOGIN>>>>>>>>>>>>",sharedPref.getBoolean("IS_LOGIN",false).toString())

        Handler().postDelayed(Runnable {
            if(sharedPref.getBoolean("IS_LOGIN",false))
            {
                startActivity(Intent(this@SplashScreenActivity,MainActivity::class.java))
            }else{
                startActivity(Intent(this@SplashScreenActivity,LoginActivity::class.java))
            }

            finish()
        },2000)
    }

}
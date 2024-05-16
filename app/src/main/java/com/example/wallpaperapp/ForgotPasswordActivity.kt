package com.example.wallpaperapp

import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.wallpaperapp.databinding.ActivityForgotPasswordBinding

class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var fBinding : ActivityForgotPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }

        fBinding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(fBinding.root)

        fBinding.bntResetLink.isEnabled = false

        fBinding.bntResetLink.setOnClickListener{
            TODO()
        }


    }

}
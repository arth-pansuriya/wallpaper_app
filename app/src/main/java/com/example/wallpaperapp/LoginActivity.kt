package com.example.wallpaperapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.wallpaperapp.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.bntClick.setOnClickListener {

            var sharedPreLogin : SharedPreferences = this
                .getSharedPreferences("MCAPref", MODE_PRIVATE)

            var editlogin : SharedPreferences.Editor = sharedPreLogin.edit()



            if(sharedPreLogin.getString("EMAIL",null).toString() == binding.edtEmail.text.toString()
                &&
                sharedPreLogin.getString("PASS",null).toString() == binding.edtPassword.text.toString()
            )
            {

                editlogin.apply {
                    putBoolean("IS_LOGIN",true)
                }.apply()

                editlogin.commit()

                startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                finish()
            }
            else{
                Toast.makeText(this,"invalid Credential..!", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnRegister.setOnClickListener {
            startActivity(Intent(this@LoginActivity,RegisterActivity::class.java))
        }

        binding.btnForgotPass.setOnClickListener {
            startActivity(Intent(this@LoginActivity, ForgotPasswordActivity::class.java))
        }

    }

}
package com.example.wallpaperapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Bitmap
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import com.example.wallpaperapp.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {

    private lateinit var rBinding : ActivityRegisterBinding //Declare

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }

        rBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(rBinding.root)

        rBinding.bntSubmit.isEnabled = false

        rBinding.chkTermsCondition.setOnCheckedChangeListener { _, isChecked ->
            rBinding.bntSubmit.isEnabled = isChecked == true
        }

//        rBinding.imgProfile.setOnClickListener {
//            var intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
//            startActivityForResult(intent,123)
//        }


        rBinding.bntSubmit.setOnClickListener {

            var sharedPref : SharedPreferences = this
                .getSharedPreferences("MCAPref", MODE_PRIVATE)

            var prefEditor : SharedPreferences.Editor = sharedPref.edit()

            prefEditor.apply {
                putString("EMAIL",rBinding.edtEmail.text.toString().trim())
                putString("PASS",rBinding.edtPassword.text.toString().trim())
            }.apply()

            prefEditor.commit()

            Log.d("PREF>>>>>>> EMAIL>>>>",sharedPref.getString("EMAIL",null).toString())
            Log.d("PREF>>>>>>> PASS>>>>",sharedPref.getString("PASS",null).toString())

            finish()
        }

    }

//    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
//        super.onActivityResult(requestCode, resultCode, data)
//
//        if(requestCode == 123)
//        {
//            rBinding.imgProfile.setImageBitmap(data!!.extras!!.get("data") as Bitmap)
//        }
//    }

}
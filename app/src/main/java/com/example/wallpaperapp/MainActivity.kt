package com.example.wallpaperapp

import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.wallpaperapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    private lateinit var masonryAdapter: MasonryAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        window.setStatusBarColor(Color.TRANSPARENT);
//        window.setNavigationBarColor(Color.TRANSPARENT);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.setDecorFitsSystemWindows(false)
//            window.setStatusBarContrastEnforced(false)
//            window.setNavigationBarContrastEnforced(false)
        }

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogout.setOnClickListener {
            var sharedPref : SharedPreferences = this.getSharedPreferences("MCAPref", MODE_PRIVATE)

            var editPREF : SharedPreferences.Editor = sharedPref.edit()

            editPREF.clear()

            editPREF.commit()

            startActivity(Intent(this,LoginActivity::class.java))
            finishAffinity() // All screen are Close
        }

        masonryAdapter = MasonryAdapter(this@MainActivity)
        binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL)
        binding.recyclerView.adapter =masonryAdapter

        wpData()

    }

    private fun wpData(){

        masonryAdapter.imgList = ArrayList()

        var img = GridImageData(R.drawable.w1)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w2)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w3)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w4)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w5)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w6)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w7)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w8)
        masonryAdapter.imgList.add(img)
        img = GridImageData(R.drawable.w9)
        masonryAdapter.imgList.add(img)


    }

}
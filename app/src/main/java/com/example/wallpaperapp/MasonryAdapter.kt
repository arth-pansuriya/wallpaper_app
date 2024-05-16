package com.example.wallpaperapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class MasonryAdapter(private val context: Context) : RecyclerView.Adapter<MasonryAdapter.ViewHolder>() {

    var imgList : ArrayList<GridImageData> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.layout_grid, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.imageView.setImageResource(imgList[position].image)
        holder.cardView.setOnClickListener{

            Toast.makeText(context,"tap>>>>",Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return imgList.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.findViewById<ImageView>(R.id.wpimg)
        val cardView = itemView.findViewById<CardView>(R.id.cardView)
    }
}
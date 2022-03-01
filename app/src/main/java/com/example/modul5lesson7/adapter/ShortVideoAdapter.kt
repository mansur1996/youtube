package com.example.modul5lesson7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson7.R
import com.example.modul5lesson7.model.Short

class ShortVideoAdapter(var context: Context, val items : ArrayList<Short>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ShortVideosViewHolder(LayoutInflater.from(context).inflate(R.layout.item_short_videos, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = items[position]

        if(holder is ShortVideosViewHolder){
            holder.apply {
                ivVideo.setImageResource(item.videos)
                tvVideoName.text = item.nameOfVideo
                tvCountViews.text = item.views
            }
        }
    }

    override fun getItemCount(): Int  = items.size

    class ShortVideosViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var ivVideo = view.findViewById<ImageView>(R.id.iv_videoPhoto)
        var tvVideoName = view.findViewById<TextView>(R.id.tv_videoName)
        var tvCountViews = view.findViewById<TextView>(R.id.tv_countViews)
    }
}
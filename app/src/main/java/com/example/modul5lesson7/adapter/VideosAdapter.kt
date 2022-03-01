package com.example.modul5lesson7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson7.R
import com.example.modul5lesson7.model.Short
import com.example.modul5lesson7.model.Videos
import com.google.android.material.imageview.ShapeableImageView

class VideosAdapter(var context: Context, var items: ArrayList<Videos>)
    :RecyclerView.Adapter<RecyclerView.ViewHolder>(){

    private val TYPE_ITEM_FEED = 0
    private val TYPE_ITEM_SHORT = 1

    override fun getItemViewType(position: Int): Int {
        val videos = items[position]

        if(videos.shorts.size > 0) return TYPE_ITEM_SHORT
        return TYPE_ITEM_FEED
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if(viewType == TYPE_ITEM_SHORT){
            return ShortViewHolder(LayoutInflater.from(context).inflate(R.layout.short_videos_activity, parent, false))
        }
        return FeedViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_video, parent, false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val video = items[position]

        if(holder is ShortViewHolder){
            val recyclerView : RecyclerView = holder.rv_shortVideos
            recyclerView.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

            refreshAdapter(recyclerView, video.shorts)
        }

        if(holder is FeedViewHolder){
            holder.apply {
                ivVideo.setImageResource(video.feeds!!.photo)
                ivProfile.setImageResource(video.feeds!!.profile)
            }
        }

    }

    fun refreshAdapter(rv : RecyclerView, shorts:ArrayList<Short>){
        rv.adapter = ShortVideoAdapter(context, shorts)
    }

    override fun getItemCount(): Int = items.size

    class ShortViewHolder(view : View):RecyclerView.ViewHolder(view){
        var rv_shortVideos = view.findViewById<RecyclerView>(R.id.rv_shortVideos)
    }

    class FeedViewHolder(view : View):RecyclerView.ViewHolder(view){
        var ivVideo = view.findViewById<ImageView>(R.id.iv_video)
        var ivProfile = view.findViewById<ShapeableImageView>(R.id.iv_profile)
    }

}
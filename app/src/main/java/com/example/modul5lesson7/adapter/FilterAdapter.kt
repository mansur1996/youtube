package com.example.modul5lesson7.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson7.R
import com.example.modul5lesson7.model.Filter

class FilterAdapter(var context: Context, var items : ArrayList<Filter>) :RecyclerView.Adapter<RecyclerView.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return FilterViewHolder(LayoutInflater.from(context).inflate(R.layout.item_feed_filter,parent,false))
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val filter = items[position]

        if(holder is FilterViewHolder){
            holder.apply {
                tv_title.text = filter.title
            }
        }
    }

    override fun getItemCount(): Int = items.size

    class FilterViewHolder(view: View) : RecyclerView.ViewHolder(view){
        var tv_title = view.findViewById<TextView>(R.id.tv_title)
    }
}
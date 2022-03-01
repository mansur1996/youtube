package com.example.modul5lesson7

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modul5lesson7.adapter.VideosAdapter
import com.example.modul5lesson7.adapter.FilterAdapter
import com.example.modul5lesson7.model.Feed
import com.example.modul5lesson7.model.Filter
import com.example.modul5lesson7.model.Short
import com.example.modul5lesson7.model.Videos

class MainActivity : AppCompatActivity() {

    lateinit var recyclerViewFeed: RecyclerView
    lateinit var recyclerViewFilter: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initViews()
    }

    fun initViews(){
        recyclerViewFilter = findViewById(R.id.rv_Filter)
        recyclerViewFilter.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false)

        recyclerViewFeed = findViewById(R.id.rv_Feed)
        recyclerViewFeed.layoutManager = GridLayoutManager(this, 1)

        refreshStoryAdapter(getAllFilters())
        refreshFeedAdapter(getAllFeeds())
    }

    fun refreshFeedAdapter(videos: ArrayList<Videos>){
        recyclerViewFeed.adapter = VideosAdapter(this,videos)
    }

    fun getAllFeeds() : ArrayList<Videos>{
        val shorts : ArrayList<Short> = ArrayList()

        shorts.add(Short(R.drawable.img_computer_6, "PDP Academy the best #of #the #best", "144K"))
        shorts.add(Short(R.drawable.img_computer_5, "PDP Academy the best #of #the #best", "144K"))
        shorts.add(Short(R.drawable.img_computer_2, "PDP Academy the best #of #the #best", "111K"))
        shorts.add(Short(R.drawable.img_computer_4, "PDP Academy the best #of #the #best", "133K"))
        shorts.add(Short(R.drawable.img_computer_3, "PDP Academy the best #of #the #best", "122K"))
        shorts.add(Short(R.drawable.img_computer_1, "PDP Academy the best #of #the #best", "107K"))

        val videos : ArrayList<Videos> = ArrayList()
        

        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_1)))
        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_2)))
        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_3)))

        videos.add(Videos(shorts))

        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_4)))
        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_5)))
        videos.add(Videos(Feed(R.drawable.img_profile, R.drawable.img_computer_6)))

        return videos
    }

    fun refreshStoryAdapter(chats : ArrayList<Filter>){
        recyclerViewFilter.adapter = FilterAdapter(this, chats)
    }

    fun getAllFilters():ArrayList<Filter>{
        val filters : ArrayList<Filter> = ArrayList()

        filters.add(Filter("Computer Programming"))
        filters.add(Filter("Android Native"))
        filters.add(Filter("Mobile Development"))
        filters.add(Filter("Football"))
        filters.add(Filter("Live"))
        filters.add(Filter("Country"))
        filters.add(Filter("Food"))

        return filters
    }
}

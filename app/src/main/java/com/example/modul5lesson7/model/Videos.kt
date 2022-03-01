package com.example.modul5lesson7.model

import kotlin.Short

class Videos{
    var shorts : ArrayList<com.example.modul5lesson7.model.Short> = ArrayList()
    var feeds : Feed? = null


    constructor(feed: Feed){
        feeds = feed
    }

    constructor(shorts: ArrayList<com.example.modul5lesson7.model.Short>){
        this.shorts = shorts
    }
}
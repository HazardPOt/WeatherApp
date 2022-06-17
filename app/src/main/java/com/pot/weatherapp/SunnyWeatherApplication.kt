package com.pot.weatherapp

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application() {
    companion object{
        @SuppressLint("StaticFieldLeak")
        lateinit var context : Context
        const val TOKEN = "rdZHp7GC4AK2oBLT"
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}
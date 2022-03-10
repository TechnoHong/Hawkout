package com.example.hawkout

import android.app.Application
import com.example.hawkout.util.PreferenceUtil

class HawkoutApplication: Application() {
    companion object {
        lateinit var prefs: PreferenceUtil
    }

    override fun onCreate() {
        prefs = PreferenceUtil(applicationContext)
        super.onCreate()
    }
}
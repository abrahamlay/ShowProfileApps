package com.abraham.showprofileapps.util

import android.app.Application
import android.content.Context

/**
 * Created by Abraham on 05/09/2018.
 */
class MyApp:Application(){
    var PARAM_PREFS_NAME: String="MyAppSharedPreference"
    lateinit var editor: UtilSharedPreference
    override fun onCreate() {
        super.onCreate()
        instance=this
        editor=UtilSharedPreference(applicationContext,getSharedPreferences(PARAM_PREFS_NAME, Context.MODE_PRIVATE))
    }

    companion object {
        private lateinit var instance: MyApp
        @Synchronized
        internal fun getInstance(): MyApp {
            return instance
        }
    }

}
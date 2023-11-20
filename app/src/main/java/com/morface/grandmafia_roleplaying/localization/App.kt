package com.morface.grandmafia_roleplaying.localization

import android.app.Application
import android.preference.PreferenceManager
import java.util.Locale

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        var change = ""
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val language = sharedPreferences.getString("language", "bak")
        if (language == "Persian") {
            change = "fa"
        } else if (language == "English") {
            change = "en"
        } else {
            change = "fa"
        }

        BaseActivity.dLocale = Locale(change) //set any locale you want here
    }
}

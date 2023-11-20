package com.morface.grandmafia_roleplaying.storage

import android.content.Context
import android.content.SharedPreferences

class Storage(context: Context) {
    var preferences: SharedPreferences =
        context.getSharedPreferences("sp", Context.MODE_PRIVATE)

    fun getTheme(): String {
        return preferences.getString("theme", "Dark")!!
    }

    fun setTheme(themeName: String) {
        preferences.edit().putString("theme", themeName).apply()
    }
}
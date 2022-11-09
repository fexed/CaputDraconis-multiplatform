package com.fexed.caputdraconis

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class AndroidPlatform : Platform {
    override val name: String = "Android"
    override val appVersion: String = "v0.3"
}

actual fun getPlatform(): Platform = AndroidPlatform()

actual typealias Preferences = Activity
actual fun Preferences.getString(key: String, default: String) : String? {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getString(key, default)
}


actual fun Preferences.setString(key: String, value: String) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putString(key, value)
    editor.apply()
}

actual fun Preferences.getInt(key: String, default: Int) : Int? {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getInt(key, default)
}


actual fun Preferences.setInt(key: String, value: Int) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putInt(key,value)
    editor.apply()
}

actual fun Preferences.getBoolean(key: String, default: Boolean) : Boolean? {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    return prefs.getBoolean(key, default)
}


actual fun Preferences.setBoolean(key: String, value: Boolean) {
    val prefs: SharedPreferences = this.getSharedPreferences("", MODE_PRIVATE)
    val editor = prefs.edit()
    editor.putBoolean(key, value)
    editor.apply()
}
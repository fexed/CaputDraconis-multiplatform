package com.fexed.caputdraconis

expect class Preferences
expect fun Preferences.setString(key: String, value: String)
expect fun Preferences.getString(key: String, default: String): String?
expect fun Preferences.setInt(key: String, value: Int)
expect fun Preferences.getInt(key: String, default: Int): Int?
expect fun Preferences.setBoolean(key: String, value: Boolean)
expect fun Preferences.getBoolean(key: String, default: Boolean): Boolean?
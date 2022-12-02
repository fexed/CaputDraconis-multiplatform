package com.fexed.caputdraconis

import platform.Foundation.NSUserDefaults
import platform.darwin.NSObject

class IOSPlatform: Platform {
    override val name: String = "iOS"
    override val appVersion: String = "v1.0"
}

actual fun getPlatform(): Platform = IOSPlatform()

actual typealias Preferences = NSObject

actual fun Preferences.getInt(key: String, default: Int) : Int? {
    return NSUserDefaults.standardUserDefaults.integerForKey(key).toInt()
}

actual fun Preferences.setInt(key: String, value: Int){
    NSUserDefaults.standardUserDefaults.setInteger(value.toLong(), key)
}

actual fun Preferences.getString(key: String, default: String) : String? {
    return NSUserDefaults.standardUserDefaults.stringForKey(key)
}

actual fun Preferences.setString(key: String, value: String){
    NSUserDefaults.standardUserDefaults.setString(value, key)
}

actual fun Preferences.getBoolean(key: String, default: Boolean) : Boolean? {
    return NSUserDefaults.standardUserDefaults.boolForKey(key)
}

actual fun Preferences.setBoolean(key: String, value: Boolean){
    NSUserDefaults.standardUserDefaults.setBool(value, key)
}
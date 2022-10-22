package com.fexed.caputdraconis

class AndroidPlatform : Platform {
    override val name: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val version: String = "Expelliarmus v0.1\nAndroid v0.1"
}

actual fun getPlatform(): Platform = AndroidPlatform()
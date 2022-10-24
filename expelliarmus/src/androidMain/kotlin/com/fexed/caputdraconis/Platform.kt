package com.fexed.caputdraconis

class AndroidPlatform : Platform {
    override val name: String = "Android"
    override val appVersion: String = "v0.1"
}

actual fun getPlatform(): Platform = AndroidPlatform()
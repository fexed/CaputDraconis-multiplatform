package com.fexed.caputdraconis

class IOSPlatform: Platform {
    override val name: String = "iOS"
    override val appVersion: String = "v0.1"
}

actual fun getPlatform(): Platform = IOSPlatform()
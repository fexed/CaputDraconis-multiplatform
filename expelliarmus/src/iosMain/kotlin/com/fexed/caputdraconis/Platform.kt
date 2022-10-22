package com.fexed.caputdraconis

import platform.UIKit.UIDevice

class IOSPlatform: Platform {
    override val name: String = UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val version: String = "Expelliarmus v0.1\niOS v0.1"
}

actual fun getPlatform(): Platform = IOSPlatform()
package com.fexed.caputdraconis

interface Platform {
    val name: String
    val appVersion: String
    val commonVersion: String
        get() = "v0.5"

    fun getVersion(): String {
        return "$name $appVersion - Expelliarmus $commonVersion"
    }
}

expect fun getPlatform(): Platform
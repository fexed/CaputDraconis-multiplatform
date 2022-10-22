package com.fexed.caputdraconis

import android.util.Log

class AndroidSpellsLoader: SpellsLoader {
    override fun GetCSVFromAssets(): String {
        Log.d("SPELLS", "Loading CSV")
        //TODO("Not yet implemented")
        return ""
    }
}

actual fun getSpellsLoader(): SpellsLoader = AndroidSpellsLoader()
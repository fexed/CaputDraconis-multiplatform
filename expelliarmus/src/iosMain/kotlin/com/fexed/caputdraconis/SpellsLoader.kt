package com.fexed.caputdraconis

class iOSSpellsLoader: SpellsLoader {
    override fun GetCSVFromAssets(): String {
        print("SPELLS\tLoading CSV\n")
        //TODO("Not yet implemented")
        return ""
    }

}

actual fun getSpellsLoader(): SpellsLoader = iOSSpellsLoader()
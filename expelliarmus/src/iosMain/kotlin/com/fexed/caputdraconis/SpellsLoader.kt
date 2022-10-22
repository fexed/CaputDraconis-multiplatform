package com.fexed.caputdraconis

class iOSSpellsLoader: SpellsLoader {
    override fun GetCSVFromAssets(): String {
        print("SPELLS\tLoading CSV\n")

        return ""
    }

}

actual fun getSpellsLoader(): SpellsLoader = iOSSpellsLoader()
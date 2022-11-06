package com.fexed.caputdraconis

import android.util.Log
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class AndroidSpellsLoader: SpellsLoader {
    companion object {
        lateinit var CSVFile: InputStream
    }

    override fun GetCSVFromAssets(): String {
        var output = ""
        with(CSVFile) {
            output = BufferedReader(InputStreamReader(this)).useLines { lines ->
                val results = StringBuilder()
                lines.forEach { results.append(it + "\n") }
                results.toString()
            }
        }
        return output
    }
}

actual fun getSpellsLoader(): SpellsLoader = AndroidSpellsLoader()
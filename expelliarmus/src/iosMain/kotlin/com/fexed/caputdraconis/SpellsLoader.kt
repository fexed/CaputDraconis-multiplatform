package com.fexed.caputdraconis

import platform.Foundation.*

class iOSSpellsLoader: SpellsLoader {
    override fun GetCSVFromAssets(): String {
        var output = ""
        println("SPELLS\tLoading CSV")
        val path = NSBundle.mainBundle().pathForResource("Incantesimi", ofType = "csv")
        val fileManager = NSFileManager()

        if (path != null && fileManager.fileExistsAtPath(path)) {
            val contents = fileManager.contentsAtPath(path)
            output = contents!!.string().toString()
        }

        println("SPELLS\tLoaded ${output.length} chars")
        return output
    }

}


fun NSData.string(): String? = NSString.create(data = this, encoding = NSUTF8StringEncoding)?.toString()

actual fun getSpellsLoader(): SpellsLoader = iOSSpellsLoader()
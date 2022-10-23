package com.fexed.caputdraconis

import platform.Foundation.*

class iOSSpellsLoader: SpellsLoader {
    override fun GetCSVFromAssets(): String {
        var output = ""
        println("SPELLS\tLoading CSV")
        val language = NSLocale.preferredLanguages.first() as String
        println("SPELLS\t$language")
        val path: String?
        path = if (language.split("-")[0] == "it")
            NSBundle.mainBundle().pathForResource("Incantesimi", ofType = "csv")
        else
            NSBundle.mainBundle().pathForResource("IncantesimiEN", ofType = "csv")
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
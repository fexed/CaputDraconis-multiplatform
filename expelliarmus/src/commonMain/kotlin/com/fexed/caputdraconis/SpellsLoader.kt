package com.fexed.caputdraconis

interface SpellsLoader {
    fun GetCSVFromAssets(): String
    fun LoadSpells(): List<Spell> {
        println("Common:SPELLS\tLoading spells")
        val list = ArrayList<Spell>()
        val CSV = GetCSVFromAssets()
        println("Common:SPELLS\tCSV Loaded: " + CSV.length + " chars")

        val lines = CSV.split("\n")

        for (line in lines) {
            println("Common:SPELLS\t" + line)
            if (line != "") {
                val rawSpell = line.split("\t")
                val parsedSpell = Spell(
                    nome = rawSpell[0],
                    descrizione = rawSpell[3],
                    categoria = rawSpell[1],
                    difinc = rawSpell[2],
                    fonte = rawSpell[4]
                )
                list.add(parsedSpell)
            }
        }
        println("Common:SPELLS\tSpell list created: " + list.size + " spells")
        return list
    }
}

expect fun getSpellsLoader(): SpellsLoader
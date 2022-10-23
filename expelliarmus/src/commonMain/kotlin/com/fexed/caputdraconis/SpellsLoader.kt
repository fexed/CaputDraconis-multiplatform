package com.fexed.caputdraconis

interface SpellsLoader {
    fun GetCSVFromAssets(): String
    fun LoadSpells(): List<Spell> {
        val list = ArrayList<Spell>()
        val CSV = GetCSVFromAssets()

        val lines = CSV.split("\n")

        for (line in lines) {
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
        return list
    }
}

expect fun getSpellsLoader(): SpellsLoader
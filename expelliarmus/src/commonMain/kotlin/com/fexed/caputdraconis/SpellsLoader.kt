package com.fexed.caputdraconis

interface SpellsLoader {
    fun GetCSVFromAssets(): String
    fun LoadSpells(): List<Spell> {
        print("SPELLS\tLoading spells\n")
        val list = ArrayList<Spell>()
        val CSV = GetCSVFromAssets()
        list.add(Spell("Incantesimo di prova", "Questo è un incantesimo di prova", "Protego?", "Magico", "Fexed"))
        list.add(Spell("Incantesimo di prova n.2", "Questo è un altro incantesimo di prova", "Protego?", "Magico", "Fexed"))
        return list
    }
}

expect fun getSpellsLoader(): SpellsLoader
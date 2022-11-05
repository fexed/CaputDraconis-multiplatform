package com.fexed.caputdraconis

class SpellListUtility {
    companion object {
        fun Search(query: String, spellList: List<Spell>): List<Spell> {
            val resultList = mutableListOf<Spell>()
            val lookFor = query.lowercase()

            for (spell in spellList) {
                if (spell.nome.lowercase().contains(lookFor) ||
                    spell.fonte.lowercase().contains(lookFor) ||
                    spell.categoria.lowercase().contains(lookFor) ||
                    spell.difinc.lowercase().contains(lookFor) ||
                    spell.descrizione.lowercase().contains(lookFor)) {
                    resultList.add(spell)
                }
            }

            return resultList
        }

        fun SearchForName(name: String, spellList: List<Spell>): List<Spell> {
            val resultList = mutableListOf<Spell>()
            val lookFor = name.lowercase()

            for (spell in spellList) {
                if (spell.nome.lowercase().contains(lookFor)) {
                    resultList.add(spell)
                }
            }

            return resultList
        }

        fun SearchForDefensiveSpell(defensiveSpellName: String, spellList: List<Spell>): List<Spell> {
            val resultList = mutableListOf<Spell>()
            val lookFor = defensiveSpellName.lowercase()

            for (spell in spellList) {
                if (spell.difinc.lowercase().contains(lookFor)) {
                    resultList.add(spell)
                }
            }

            return resultList
        }

        fun SearchForSource(source: String, spellList: List<Spell>): List<Spell> {
            val resultList = mutableListOf<Spell>()
            val lookFor = source.lowercase()

            for (spell in spellList) {
                if (spell.fonte.lowercase().contains(lookFor)) {
                    resultList.add(spell)
                }
            }

            return resultList
        }

        fun GetRandomSpell(spellList: List<Spell>): Spell {
            var spell = spellList.random()

            while(spell.nome.lowercase().contains("scutum") || spell.nome.lowercase().contains("finite") ||spell.nome.lowercase().contains("protego"))
                spell = spellList.random()

            return spell
        }
    }
}
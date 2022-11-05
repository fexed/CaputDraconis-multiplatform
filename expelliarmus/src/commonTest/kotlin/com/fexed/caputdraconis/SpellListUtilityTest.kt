package com.fexed.caputdraconis

import kotlin.test.Test
import kotlin.test.assertEquals

class SpellListUtilityTest {
    @Test
    fun testRandomGenerationSimple() {
        val spellList = mutableListOf<Spell>()
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Spell", "", "", "", ""))

        val randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)
    }

    @Test
    fun testRandomGenerationMedium() {
        val spellList = mutableListOf<Spell>()
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("Spell", "", "", "", ""))

        val randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)
    }

    @Test
    fun testRandomGenerationMediumHard() {
        val spellList = mutableListOf<Spell>()
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Spell", "", "", "", ""))

        val randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)
    }

    @Test
    fun testRandomGenerationHard() {
        val spellList = mutableListOf<Spell>()
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("proTeGO", "", "", "", ""))
        spellList.add(Spell("sCuTuM", "", "", "", ""))
        spellList.add(Spell("FINITE", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Protego", "", "", "", ""))
        spellList.add(Spell("Scutum", "", "", "", ""))
        spellList.add(Spell("Finite", "", "", "", ""))
        spellList.add(Spell("Spell", "", "", "", ""))

        spellList.shuffle()

        var randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)

        spellList.shuffle()

        randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)

        spellList.shuffle()

        randomSpell = SpellListUtility.GetRandomSpell(spellList)

        assertEquals("Spell", randomSpell.nome)
    }
}
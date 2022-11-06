package com.fexed.caputdraconis.duels

import com.fexed.caputdraconis.Preferences
import com.fexed.caputdraconis.getInt
import com.fexed.caputdraconis.setInt

class DuelUtility {
    companion object {
        const val INTERVAL_MILLISECONDS = 3000  // time between spells in classic mode
        const val TIMER_MILLISECONDS = 60000  // duration in timer mode

        const val KEY_TOTAL_SPELLS = "caputdraconis_total_spells_number"

        fun incrTotalSpellsNumber(prefs: Preferences) {
            prefs.setInt(KEY_TOTAL_SPELLS, prefs.getInt(KEY_TOTAL_SPELLS, 0)!! + 1)
        }
    }
}

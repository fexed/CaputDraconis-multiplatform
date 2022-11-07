package com.fexed.caputdraconis.duels

import kotlin.test.Test

class DuelTest {

    @Test
    fun testTimer() {
        val timer = DuelTimerUtility()

        timer.createSpellTimer {  }.start()
    }
}
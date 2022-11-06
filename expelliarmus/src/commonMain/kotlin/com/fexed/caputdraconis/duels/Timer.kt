package com.fexed.caputdraconis.duels

import com.fexed.caputdraconis.duels.DuelUtility.Companion.INTERVAL_MILLISECONDS
import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// Copyright Dima Kozhevin 2019
// https://stackoverflow.com/a/58448610
class Timer {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Default + job)

    fun startCoroutineTimer(delayMillis: Long = 0, repeatMillis: Long = 0, action: () -> Unit) = scope.launch(
        defaultDispatcher) {
            delay(delayMillis)
            if (repeatMillis > 0) {
                while (true) {
                    action()
                    delay(repeatMillis)
                }
            } else {
                action()
            }
    }

    private val DuelTimer: Job = startCoroutineTimer(delayMillis = DuelUtility.TIMER_MILLISECONDS.toLong(), repeatMillis = 0) {
        //doSomethingBackground()
        scope.launch(defaultDispatcher) {
            //doSomethingMainThread()
        }
    }

    fun startDuelTimer() {
        DuelTimer.start()
    }

    fun cancelDuelTimer() {
        DuelTimer.cancel()
    }

    private val SpellTimer: Job = startCoroutineTimer(delayMillis = DuelUtility.INTERVAL_MILLISECONDS.toLong(), repeatMillis = INTERVAL_MILLISECONDS.toLong()) {
        //doSomethingBackground()
        scope.launch(defaultDispatcher) {
            //doSomethingMainThread()
        }
    }

    fun startSpellTimer() {
        SpellTimer.start()
    }

    fun cancelSpellTimer() {
        SpellTimer.cancel()
    }
}

expect val defaultDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext
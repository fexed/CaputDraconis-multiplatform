package com.fexed.caputdraconis.duels

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

// Copyright Dima Kozhevin 2019
// https://stackoverflow.com/a/58448610
class DuelTimerUtility {
    private val job = SupervisorJob()
    private val scope = CoroutineScope(Dispatchers.Default + job)
    var elapsedSeconds = 0

    fun startCoroutineTimer(delayMillis: Long = 0, repeatMillis: Long = 0, action: () -> Unit) = scope.launch(defaultDispatcher) {
        for (i in 0..(delayMillis/1000)) {
            delay(1000)
            elapsedSeconds++
        }

        if (repeatMillis > 0) {
            while (true) {
                action()
                delay(repeatMillis)
            }
        } else {
            action()
        }
    }

    fun createDuelTimer(action: () -> Unit): Job {
        return startCoroutineTimer(delayMillis = DuelUtility.TIMER_MILLISECONDS.toLong(), repeatMillis = 0) {
            scope.launch(defaultDispatcher) { action.invoke() }
        }
    }

    fun createSpellTimer(action: () -> Unit): Job {
        return startCoroutineTimer(delayMillis = DuelUtility.INTERVAL_MILLISECONDS.toLong(), repeatMillis = DuelUtility.INTERVAL_MILLISECONDS.toLong()) {
            scope.launch(defaultDispatcher) { action.invoke() }
        }
    }
}

expect val defaultDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext
package com.fexed.caputdraconis.duels

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

    private val timer: Job = startCoroutineTimer(delayMillis = 0, repeatMillis = 20000) {
        //doSomethingBackground()
        scope.launch(defaultDispatcher) {
            //doSomethingMainThread()
        }
    }

    fun startTimer() {
        timer.start()
    }

    fun cancelTimer() {
        timer.cancel()
    }
}

expect val defaultDispatcher: CoroutineContext

expect val uiDispatcher: CoroutineContext
package com.example.composeandflows.scenarios.lifecycle.data

import android.os.SystemClock
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class CounterRepository {
    fun counter(): Flow<Int> = flow {
        var counter = 0
        while (true) {
            emit(counter)
            println("Producer emits $counter")
            delay(1000)
            counter++
        }
    }

    private fun wait(elapse: Int) {
        val nextTime = SystemClock.elapsedRealtime()+elapse
        while(SystemClock.elapsedRealtime()<nextTime){
            //Do nothing
        }
    }
}

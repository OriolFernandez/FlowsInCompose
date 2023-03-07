package com.example.composeandflows.scenarios.lifecycle.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

class CounterRepository {
    fun counter(): Flow<Int> = flow {
        println("Produce init")
        var counter = 0
        while (true) {
            emit(counter)
            delay(1200)
            println("Produce emits $counter")
            counter++
        }
    }
}

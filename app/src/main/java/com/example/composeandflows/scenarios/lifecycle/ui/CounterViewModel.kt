package com.example.composeandflows.scenarios.lifecycle.ui

import androidx.lifecycle.ViewModel
import com.example.composeandflows.scenarios.lifecycle.data.CounterRepository
import com.example.composeandflows.scenarios.lifecycle.domain.model.Counters
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

class CounterViewModel(private val repository: CounterRepository) : ViewModel() {
    private var viewModelCounter = 0
    fun getCounters(): Flow<Counters> =
        repository.counter().map {
            viewModelCounter++
            Counters(it, viewModelCounter)
        }
}
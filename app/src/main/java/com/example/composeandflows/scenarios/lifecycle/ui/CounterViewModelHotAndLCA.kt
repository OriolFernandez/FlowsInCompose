package com.example.composeandflows.scenarios.lifecycle.ui

import androidx.lifecycle.viewModelScope
import com.example.composeandflows.scenarios.lifecycle.data.CounterRepository
import com.example.composeandflows.scenarios.lifecycle.domain.model.Counters
import kotlinx.coroutines.flow.SharingStarted.Companion.WhileSubscribed
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

//Convert a cold flow in a hot flow
class CounterViewModelHotAndLCA(private val repository: CounterRepository) : CounterViewModel() {
    private var viewModelCounter = 0

    override val counters: StateFlow<Counters> =
        repository.counter().map {
            viewModelCounter++
            Counters(it, viewModelCounter)
        }.stateIn(
            initialValue = Counters(0, 0),
            scope = viewModelScope,
            started = WhileSubscribed(500)
        )
}
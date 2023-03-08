package com.example.composeandflows.scenarios.lifecycle.ui

import androidx.lifecycle.viewModelScope
import com.example.composeandflows.scenarios.lifecycle.data.CounterRepository
import com.example.composeandflows.scenarios.lifecycle.domain.model.Counters
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch

class CounterViewModelHot(private val repository: CounterRepository) : CounterViewModel() {
    private val _countersFlow = MutableStateFlow(Counters(0, 0))
   override val counters: StateFlow<Counters> = _countersFlow.asStateFlow()
    private var viewModelCounter = 0

    init {
        viewModelScope.launch {
            repository.counter().map {
                viewModelCounter++
                Counters(it, viewModelCounter)
            }.collect {
                _countersFlow.emit(it)
            }
        }
    }
}
package com.example.composeandflows.scenarios.lifecycle.ui

import androidx.lifecycle.ViewModel
import com.example.composeandflows.scenarios.lifecycle.domain.model.Counters
import kotlinx.coroutines.flow.StateFlow

abstract class CounterViewModel (): ViewModel() {
   abstract val counters: StateFlow<Counters>
}
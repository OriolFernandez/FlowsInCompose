package com.example.composeandflows.scenarios.errorhandling.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composeandflows.domain.model.GPSCoordinate
import com.example.composeandflows.scenarios.errorhandling.data.GPSRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ErrorHandleViewModel(private val repository: GPSRepository) : ViewModel() {

    private val _viewState: MutableStateFlow<ViewState> =
        MutableStateFlow(ViewState.Idle)
    val viewState = _viewState.asStateFlow()

    fun startReceivingCoordinates() {
        viewModelScope.launch {
            repository.getCoordinates().map {
                ViewState.GPSCoordinateState(it)
            }.onEach {
                _viewState.update { it }
            }
        }
    }
}

sealed class ViewState {
    object Idle : ViewState()
    data class GPSCoordinateState(val gpsCoordinate: GPSCoordinate) : ViewState()
    object Error : ViewState()
}

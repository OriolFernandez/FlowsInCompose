package com.example.composeandflows.scenarios.errorhandling.data

import com.example.composeandflows.domain.model.GPSCoordinate
import com.example.composeandflows.domain.model.randomGPSCoordinate
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GPSCoordinateDataSource {
    fun getCoordinates(): Flow<GPSCoordinate> = flow {
        while (true) {
            val coordinate = randomGPSCoordinate()
            delay(100)
            emit(coordinate)
        }
    }
}
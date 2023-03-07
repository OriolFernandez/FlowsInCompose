package com.example.composeandflows.scenarios.errorhandling.data

import com.example.composeandflows.domain.model.GPSCoordinate
import kotlinx.coroutines.flow.Flow

class GPSRepository(private val dataSource: GPSCoordinateDataSource) {
    fun getCoordinates(): Flow<GPSCoordinate> = dataSource.getCoordinates()
}
package com.example.composeandflows.domain.model

import kotlin.random.Random

private val NOT_SET: Number = -1

data class GPSCoordinate(
    val latitude: Double,
    val longitude: Double,
    val altitude: Double,
    val timestamp: Long
)

fun randomGPSCoordinate(): GPSCoordinate {
    val randomLat = Random.nextDouble(-90.0, 90.0)
    val randomLong = Random.nextDouble(-180.0, 180.0)
    val randomAlt = Random.nextDouble(0.0, 1000.0)
    val randomTimestamp = System.currentTimeMillis()

    return GPSCoordinate(randomLat, randomLong, randomAlt, randomTimestamp)
}
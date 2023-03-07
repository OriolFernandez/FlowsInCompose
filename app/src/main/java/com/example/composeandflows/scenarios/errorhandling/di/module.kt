package com.example.composeandflows.scenarios.errorhandling.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.composeandflows.scenarios.errorhandling.data.GPSCoordinateDataSource
import com.example.composeandflows.scenarios.errorhandling.data.GPSRepository
import com.example.composeandflows.scenarios.errorhandling.viewmodel.ErrorHandleViewModel
import org.koin.dsl.module

val errorHandleModule = module {
    factory { GPSCoordinateDataSource() }
    factory { GPSRepository(get()) }
    viewModel { ErrorHandleViewModel(get()) }
}
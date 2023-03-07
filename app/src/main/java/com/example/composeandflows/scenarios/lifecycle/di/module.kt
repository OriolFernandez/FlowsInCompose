package com.example.composeandflows.scenarios.lifecycle.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.composeandflows.scenarios.errorhandling.data.GPSCoordinateDataSource
import com.example.composeandflows.scenarios.errorhandling.data.GPSRepository
import com.example.composeandflows.scenarios.errorhandling.viewmodel.ErrorHandleViewModel
import com.example.composeandflows.scenarios.lifecycle.data.CounterRepository
import com.example.composeandflows.scenarios.lifecycle.ui.CounterViewModel
import org.koin.dsl.module

val counterModule = module {
    single { CounterRepository() }
    viewModel { CounterViewModel(get()) }
}
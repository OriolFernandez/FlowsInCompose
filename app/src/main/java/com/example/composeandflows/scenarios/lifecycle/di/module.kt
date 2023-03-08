package com.example.composeandflows.scenarios.lifecycle.di

import org.koin.androidx.viewmodel.dsl.viewModel
import com.example.composeandflows.scenarios.lifecycle.data.CounterRepository
import com.example.composeandflows.scenarios.lifecycle.ui.CounterViewModel
import com.example.composeandflows.scenarios.lifecycle.ui.CounterViewModelHotAndLCA
import org.koin.dsl.module

val counterModule = module {
    single { CounterRepository() }
    //viewModel { CounterViewModelHot(get()) }
    viewModel<CounterViewModel> { CounterViewModelHotAndLCA(get()) }
}
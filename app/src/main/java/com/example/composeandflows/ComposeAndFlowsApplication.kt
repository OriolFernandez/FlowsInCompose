package com.example.composeandflows

import android.app.Application
import com.example.composeandflows.scenarios.lifecycle.di.counterModule
import com.example.composeandflows.scenarios.errorhandling.di.errorHandleModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext

class ComposeAndFlowsApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        GlobalContext.startKoin {
            // Log Koin into Android logger
            androidLogger()
            // Reference Android context
            androidContext(this@ComposeAndFlowsApplication)
            // Load modules
            modules(errorHandleModule, counterModule)
        }
    }
}
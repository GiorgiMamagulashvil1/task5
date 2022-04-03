package com.example.task5.app

import android.app.Application
import com.example.task5.di.dbModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App:Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(dbModule))
        }
    }
}
package com.example.task5.di

import com.example.task5.data.db.provideDao
import com.example.task5.data.db.provideDatabase
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val dbModule = module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
}
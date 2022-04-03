package com.example.task5.data.db

import android.content.Context
import androidx.room.Room
import com.example.task5.data.db.dao.StatisticsDao

fun provideDatabase(context: Context): StatisticsDatabase =
    Room.databaseBuilder(context, StatisticsDatabase::class.java, "statistic_db").build()

fun provideDao(db: StatisticsDatabase): StatisticsDao = db.getDao()
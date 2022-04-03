package com.example.task5.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.task5.data.db.dao.StatisticsDao
import com.example.task5.data.entity.StatisticEntity

@Database(entities = [StatisticEntity::class], version = 1)
abstract class StatisticsDatabase:RoomDatabase() {
    abstract fun getDao():StatisticsDao
}
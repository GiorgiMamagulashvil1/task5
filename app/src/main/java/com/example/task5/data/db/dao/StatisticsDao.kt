package com.example.task5.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.task5.data.entity.StatisticEntity

@Dao
interface StatisticsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item:StatisticEntity)

    @Query("SELECT * FROM statistic_table")
    suspend fun getAllItem():List<StatisticEntity>
}
package com.example.task5.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "statistic_table")
data class StatisticEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int? = null,
    val runDistance: Double,
    val swimDistance: Double,
    val calorie: Double
)

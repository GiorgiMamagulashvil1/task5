package com.example.task5.domain.repository

import com.example.task5.domain.model.Statistics

interface StatisticRepository {

    suspend fun insertItem(item:Statistics)
    suspend fun getAllItems():List<Statistics>
}
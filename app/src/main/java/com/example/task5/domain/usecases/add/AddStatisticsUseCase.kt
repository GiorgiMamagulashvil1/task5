package com.example.task5.domain.usecases.add

import com.example.task5.domain.model.Statistics

interface AddStatisticsUseCase{
    suspend fun insertStatisticItem(item:Statistics)
}
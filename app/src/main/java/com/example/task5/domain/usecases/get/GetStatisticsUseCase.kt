package com.example.task5.domain.usecases.get

import com.example.task5.presentation.statistics_screen.StatisticsState

interface GetStatisticsUseCase {
    suspend fun getStatistic(statisticsState: StatisticsState):Double
}
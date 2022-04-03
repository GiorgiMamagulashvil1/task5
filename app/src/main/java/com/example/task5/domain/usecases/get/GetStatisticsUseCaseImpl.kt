package com.example.task5.domain.usecases.get

import com.example.task5.domain.repository.StatisticRepository
import com.example.task5.presentation.statistics_screen.StatisticsState

class GetStatisticsUseCaseImpl(private val statisticRepository: StatisticRepository) :
    GetStatisticsUseCase {
    override suspend fun getStatistic(statisticsState: StatisticsState): Double {
        val statistics = statisticRepository.getAllItems()
        var sum = 0.0
        return when (statisticsState) {
            is StatisticsState.AverageRunDistance -> {
                statistics.map { sum += it.runDistance }
                sum / statistics.size
            }
            is StatisticsState.AverageSwimDistance -> {
                statistics.map { sum += it.swimDistance }
                sum / statistics.size
            }
            is StatisticsState.AverageCalories -> {
                statistics.map { sum += it.calories }
                sum / statistics.size
            }
            else -> {
                statistics.map { sum += it.runDistance }
                sum
            }
        }
    }

}
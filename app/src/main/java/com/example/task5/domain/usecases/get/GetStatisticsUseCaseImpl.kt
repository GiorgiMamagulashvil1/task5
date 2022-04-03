package com.example.task5.domain.usecases.get

import com.example.task5.domain.repository.StatisticRepository

class GetStatisticsUseCaseImpl(private val statisticRepository: StatisticRepository) :
    GetStatisticsUseCase {
    override suspend fun getAverageRunDistance(): Double {
        var sumOfRunDistance = 0.0
        val result = statisticRepository.getAllItems().map {
            sumOfRunDistance += it.runDistance
        }
        return sumOfRunDistance / result.size
    }

    override suspend fun getAverageSwimDistance(): Double {
        var sumOfSwimDistance = 0.0
        val result = statisticRepository.getAllItems().map { sumOfSwimDistance += it.swimDistance }
        return sumOfSwimDistance / result.size
    }

    override suspend fun getAverageCalories(): Double {
        var sumOfCalories = 0.0
        val result = statisticRepository.getAllItems().map { sumOfCalories += it.calories }
        return sumOfCalories / result.size
    }

    override suspend fun getSumOfRunDistance(): Double {
        var sumOfRunDistance = 0.0
        statisticRepository.getAllItems().map { sumOfRunDistance += it.runDistance }
        return sumOfRunDistance
    }
}
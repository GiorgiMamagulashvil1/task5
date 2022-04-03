package com.example.task5.domain.usecases.add

import com.example.task5.domain.model.Statistics
import com.example.task5.domain.repository.StatisticRepository

class AddStatisticsUseCaseImpl(private val statisticRepository: StatisticRepository) :
    AddStatisticsUseCase {
    override suspend fun insertStatisticItem(item: Statistics) {
        statisticRepository.insertItem(item)
    }
}
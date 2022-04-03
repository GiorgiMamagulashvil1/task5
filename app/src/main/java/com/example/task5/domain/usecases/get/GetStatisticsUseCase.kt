package com.example.task5.domain.usecases.get

interface GetStatisticsUseCase {
    suspend fun getAverageRunDistance():Double
    suspend fun getAverageSwimDistance():Double
    suspend fun getAverageCalories():Double
    suspend fun getSumOfRunDistance():Double
}
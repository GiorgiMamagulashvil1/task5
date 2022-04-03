package com.example.task5.presentation.statistics_screen

sealed class StatisticsState {
    object AverageRunDistance : StatisticsState()
    object AverageSwimDistance : StatisticsState()
    object AverageCalories : StatisticsState()
    object TotalRunDistance : StatisticsState()
}

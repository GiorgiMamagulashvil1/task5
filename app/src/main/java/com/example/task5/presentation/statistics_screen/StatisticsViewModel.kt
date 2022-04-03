package com.example.task5.presentation.statistics_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task5.domain.model.Statistics
import com.example.task5.domain.usecases.add.AddStatisticsUseCase
import com.example.task5.domain.usecases.get.GetStatisticsUseCase
import com.example.task5.presentation.model.StatisticUIModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class StatisticsViewModel(
    private val addStatisticsUseCase: AddStatisticsUseCase,
    private val getStatisticsUseCase: GetStatisticsUseCase
) : ViewModel() {
    private val statisticStateFlow = MutableStateFlow<StatisticUIModel?>(null)
    val statisticFlow: StateFlow<StatisticUIModel?> = statisticStateFlow

    fun setStatisticDetails() = viewModelScope.launch(Dispatchers.IO) {
        statisticStateFlow.emit(
            StatisticUIModel(
                avrRunDistance = getStatisticsUseCase.getStatistic(StatisticsState.AverageRunDistance),
                avrSwimDistance = getStatisticsUseCase.getStatistic(StatisticsState.AverageSwimDistance),
                avrCalories = getStatisticsUseCase.getStatistic(StatisticsState.AverageCalories),
                totalRunDistance = getStatisticsUseCase.getStatistic(StatisticsState.TotalRunDistance)
            )
        )
    }

    fun setStatistic(runDistance: Double, swimDistance: Double, calories: Double) =
        viewModelScope.launch(Dispatchers.IO) {
            val statistic = Statistics(
                runDistance = runDistance,
                swimDistance = swimDistance,
                calories = calories
            )
            addStatisticsUseCase.insertStatisticItem(statistic)
        }
}
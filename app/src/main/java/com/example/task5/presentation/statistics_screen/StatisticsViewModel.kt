package com.example.task5.presentation.statistics_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.task5.domain.model.Statistics
import com.example.task5.domain.usecases.add.AddStatisticsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class StatisticsViewModel(
    private val addStatisticsUseCase: AddStatisticsUseCase
) : ViewModel() {
    fun setStatistic(runDistance: Int, swimDistance: Int, calories: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            val statistic = Statistics(
                runDistance = runDistance,
                swimDistance = swimDistance,
                calories = calories
            )
            addStatisticsUseCase.insertStatisticItem(statistic)
        }
}
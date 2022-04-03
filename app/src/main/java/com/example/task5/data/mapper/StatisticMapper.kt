package com.example.task5.data.mapper

import com.example.task5.data.entity.StatisticEntity
import com.example.task5.domain.model.Statistics

class StatisticMapper : Mapper<StatisticEntity, Statistics> {
    override fun mapModel(item: StatisticEntity): Statistics {
        with(item) {
            return Statistics(
                swimDistance = swimDistance,
                id = id!!,
                runDistance = runDistance,
                calories = calorie
            )
        }
    }
}
package com.example.task5.domain.mapper

import com.example.task5.data.entity.StatisticEntity
import com.example.task5.data.mapper.Mapper
import com.example.task5.domain.model.Statistics

class StatisticDomainMapper:Mapper<Statistics,StatisticEntity> {
    override fun mapModel(item: Statistics): StatisticEntity {
        with(item){
            return StatisticEntity(
                runDistance = runDistance,
                swimDistance = swimDistance,
                calorie = calories
            )
        }
    }
}
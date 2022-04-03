package com.example.task5.data.repository

import com.example.task5.data.db.dao.StatisticsDao
import com.example.task5.data.mapper.StatisticMapper
import com.example.task5.domain.mapper.StatisticDomainMapper
import com.example.task5.domain.model.Statistics
import com.example.task5.domain.repository.StatisticRepository

class StatisticRepositoryImpl(
    private val dao: StatisticsDao,
    private val statisticMapper: StatisticMapper,
    private val statisticDomainMapper: StatisticDomainMapper
) : StatisticRepository {
    override suspend fun insertItem(item: Statistics) {
        dao.insert(statisticDomainMapper.mapModel(item))
    }

    override suspend fun getAllItems(): List<Statistics> {
        return statisticMapper.mapToList(dao.getAllItem())
    }
}
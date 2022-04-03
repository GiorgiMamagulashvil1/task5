package com.example.task5.di

import com.example.task5.data.db.provideDao
import com.example.task5.data.db.provideDatabase
import com.example.task5.data.mapper.StatisticMapper
import com.example.task5.data.repository.StatisticRepositoryImpl
import com.example.task5.domain.mapper.StatisticDomainMapper
import com.example.task5.domain.repository.StatisticRepository
import com.example.task5.domain.usecases.add.AddStatisticsUseCase
import com.example.task5.domain.usecases.add.AddStatisticsUseCaseImpl
import com.example.task5.domain.usecases.get.GetStatisticsUseCase
import com.example.task5.domain.usecases.get.GetStatisticsUseCaseImpl
import com.example.task5.presentation.statistics_screen.StatisticsViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val dbModule = module {
    single { provideDatabase(androidContext()) }
    single { provideDao(get()) }
}
val mapperModule = module {
    single { StatisticMapper() }
    single { StatisticDomainMapper() }
}
val repoModule = module {
    factory<StatisticRepository> { StatisticRepositoryImpl(get(), get(), get()) }
}
val vmModule = module {
    viewModel { StatisticsViewModel(addStatisticsUseCase = get(),get()) }
}
val useCaseModule = module {
    factory<AddStatisticsUseCase> { AddStatisticsUseCaseImpl(get()) }
    factory<GetStatisticsUseCase> { GetStatisticsUseCaseImpl(get()) }
}
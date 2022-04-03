package com.example.task5.presentation.custom_bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.task5.R
import com.example.task5.databinding.DetailDialogBinding
import com.example.task5.presentation.model.StatisticUIModel
import com.example.task5.presentation.statistics_screen.StatisticsViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import kotlin.properties.Delegates

class DetailsBottomSheet : BottomSheetDialogFragment() {

    private var _binding: DetailDialogBinding? = null
    private val binding get() = _binding!!

    private var avrRunDistance by Delegates.notNull<Double>()
    private var avrSwimDistance by Delegates.notNull<Double>()
    private var avrCalories by Delegates.notNull<Double>()
    private var totalRunDistance by Delegates.notNull<Double>()

    private lateinit var statistUiModel: StatisticUIModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DetailDialogBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setDetailsInfo()
    }

    private fun setDetailsInfo() {
        with(binding) {
            averageRunDistanceTextView.text = getString(
                R.string.avr_distance,
                getString(R.string.text_run_distance),
                statistUiModel.avrRunDistance
            )
            averageSwimDistanceTextView.text = getString(
                R.string.avr_distance,
                getString(R.string.text_swim_distance),
                statistUiModel.avrSwimDistance
            )
            averageCaloriesTextView.text = getString(
                R.string.avr_calories,
                statistUiModel.avrCalories
            )
            totalDistanceTextView.text = getString(R.string.total_distance,statistUiModel.totalRunDistance)
        }
    }

    fun setDetails(
        avrRunDistance: Double,
        avrSwimDistance: Double,
        avrCalories: Double,
        totalRunDistance: Double
    ) {
        this.statistUiModel = StatisticUIModel(
            avrRunDistance,avrSwimDistance,avrCalories,totalRunDistance
        )
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
package com.example.task5.presentation.statistics_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.example.task5.databinding.StatisticsFragmentBinding
import com.example.task5.presentation.custom_bottomsheet.DetailsBottomSheet
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatisticsFragment : Fragment() {
    private var _binding: StatisticsFragmentBinding? = null
    private val binding get() = _binding!!

    private val vm: StatisticsViewModel by viewModel()
    private lateinit var detailBottomSheet: DetailsBottomSheet

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = StatisticsFragmentBinding.inflate(layoutInflater, container, false)
        return _binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        vm.setStatisticDetails()
        observeDetails()
    }

    private fun observeDetails() {
        detailBottomSheet = DetailsBottomSheet()
        viewLifecycleOwner.lifecycleScope.launch {
            vm.statisticFlow.collect { detail ->
                detail?.let {
                    detailBottomSheet.setDetails(
                        it.avrRunDistance,
                        it.avrSwimDistance,
                        it.avrCalories,
                        it.totalRunDistance
                    )
                }
            }
        }
    }

    private fun setListeners() {
        with(binding) {
            saveButton.setOnClickListener {
                setStatisticParameters()
            }
            showStatisticButton.setOnClickListener {
                vm.setStatisticDetails()
                detailBottomSheet.show(childFragmentManager, null)
            }
        }
    }

    private fun setStatisticParameters() {
        with(binding) {
            vm.setStatistic(
                runDistanceEditText.text.convertToDouble(),
                swimDistanceEditText.text.convertToDouble(),
                caloriesEditText.text.convertToDouble()
            )
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
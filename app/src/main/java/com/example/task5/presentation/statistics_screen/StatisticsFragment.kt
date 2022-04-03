package com.example.task5.presentation.statistics_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task5.databinding.StatisticsFragmentBinding
import org.koin.android.ext.android.get
import org.koin.androidx.viewmodel.ext.android.viewModel

class StatisticsFragment : Fragment() {
    private var _binding: StatisticsFragmentBinding? = null
    private val binding get() = _binding!!

    private val vm: StatisticsViewModel by viewModel()
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
    }

    private fun setListeners(){
        with(binding){
            saveButton.setOnClickListener {
                setStatisticParameters()
            }
        }
    }
    private fun setStatisticParameters() {
        with(binding) {
            vm.setStatistic(
                runDistanceEditText.text.convertToInt(),
                swimDistanceEditText.text.convertToInt(),
                caloriesEditText.text.convertToInt()
            )
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
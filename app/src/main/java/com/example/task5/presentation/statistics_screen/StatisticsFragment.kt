package com.example.task5.presentation.statistics_screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.task5.databinding.StatisticsFragmentBinding

class StatisticsFragment : Fragment() {
    private var _binding:StatisticsFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = StatisticsFragmentBinding.inflate(layoutInflater,container,false)
        return _binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
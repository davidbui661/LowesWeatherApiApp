package com.example.lowesweatherapiapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapiapp.R
import com.example.lowesweatherapiapp.databinding.SearchFragmentBinding
import com.example.lowesweatherapiapp.utils.updateSupportBar
import com.example.lowesweatherapiapp.viewmodels.WeatherViewModel

class SearchFragment : Fragment() {

    private var binding: SearchFragmentBinding? = null
    private val weatherViewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = SearchFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.let { v ->
            v.searchButton.setOnClickListener {
                weatherViewModel.getWeather(v.cityText.text.toString())
            }

            weatherViewModel.progressIsVisible.observe(viewLifecycleOwner) {
                v.progressBar.isVisible = it
            }

            weatherViewModel.errorMessage.observe(viewLifecycleOwner) {
                v.cityInputLayout.error = it
            }

            weatherViewModel.navigateToHourlyFragment.observe(viewLifecycleOwner) {
                if (it == true) {
                    v.cityText.text = null
                    v.cityInputLayout.error = null
                    findNavController().navigate(R.id.list_fragment)
                    weatherViewModel.shouldNavigate(false)
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        updateSupportBar(getString(R.string.app_name))
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }
}
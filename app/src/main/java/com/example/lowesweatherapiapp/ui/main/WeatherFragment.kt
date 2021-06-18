package com.example.lowesweatherapiapp.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapiapp.R
import com.example.lowesweatherapiapp.data.models.HourlyWeatherDTO
import com.example.lowesweatherapiapp.databinding.ListFragmentBinding
import com.example.lowesweatherapiapp.ui.adapters.HourlyWeatherAdapter
import com.example.lowesweatherapiapp.utils.updateSupportBar
import com.example.lowesweatherapiapp.viewmodels.WeatherViewModel

class WeatherFragment : Fragment() {

    private var binding: ListFragmentBinding? = null
    private val weatherViewModel: WeatherViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        binding = ListFragmentBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        updateSupportBar(weatherViewModel.cityName,
            AppCompatResources.getDrawable(requireContext(), R.drawable.ic_outline_arrow_back_24))

        binding?.let { binding ->
            weatherViewModel.weatherList.observe(viewLifecycleOwner) { weather ->
                binding.hourlyRecyclerView.apply {
                    adapter = HourlyWeatherAdapter(weather.list, this@WeatherFragment::onWeatherItemClick)
                }
            }
        }
    }

    private fun onWeatherItemClick(hourlyWeather: HourlyWeatherDTO) {
        weatherViewModel.hourlyWeather = hourlyWeather
        findNavController().navigate(R.id.action_from_list_fragment_to_details_fragment)
    }

    override fun onDestroy() {
        super.onDestroy()
        binding = null
    }


}
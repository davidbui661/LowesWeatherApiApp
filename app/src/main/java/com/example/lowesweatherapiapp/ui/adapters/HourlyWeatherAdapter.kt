package com.example.lowesweatherapiapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lowesweatherapiapp.R
import com.example.lowesweatherapiapp.data.models.HourlyWeatherDTO
import com.example.lowesweatherapiapp.databinding.WeatherItemBinding

class HourlyWeatherAdapter(private val hourly: List<HourlyWeatherDTO>, private val listener: (weather: HourlyWeatherDTO) -> Unit): RecyclerView.Adapter<HourlyWeatherAdapter.HourlyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HourlyViewHolder {
        val view = WeatherItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return HourlyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HourlyViewHolder, position: Int): Unit = with(holder)  {
        val hourly = hourly[position]
        holder.itemView.setOnClickListener{
            listener(hourly)
        }
        loadData(hourly)
    }

    override fun getItemCount(): Int = hourly.size

    class HourlyViewHolder(private var binding: WeatherItemBinding): RecyclerView.ViewHolder(binding.root){
        fun loadData(hourly: HourlyWeatherDTO) = with(binding) {
            weatherDescription.text = hourly.weather[0].main

            temp.text = String.format(
                binding.root.context.getString(
                    R.string.weather_temp,
                    hourly.main?.temp?.toInt().toString()
                )
            )
        }
    }

}
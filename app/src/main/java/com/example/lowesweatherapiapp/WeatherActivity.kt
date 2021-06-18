package com.example.lowesweatherapiapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController

class WeatherActivity: FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        findNavController(R.id.nav_host_fragment_container)
            .setGraph(R.navigation.nav_graph)
    }
}
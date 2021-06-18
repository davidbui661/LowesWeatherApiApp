package com.example.lowesweatherapiapp.utils

import android.graphics.drawable.Drawable
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.lowesweatherapiapp.R

fun Fragment.updateSupportBar(title: String = " ", icon : Drawable? = null) {
    requireActivity().findViewById<Toolbar>(R.id.toolbar).apply {
        this?.title = title
        navigationIcon = icon
        setNavigationOnClickListener {
            this@updateSupportBar.findNavController().navigateUp()
        }
    }
}
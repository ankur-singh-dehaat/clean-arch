package com.example.cleanarchitecture.utils

import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

inline fun <T : ViewBinding> AppCompatActivity.activityViewBinding(
    crossinline factory: (LayoutInflater) -> T
) = lazy(LazyThreadSafetyMode.NONE) {
    factory(layoutInflater)
}

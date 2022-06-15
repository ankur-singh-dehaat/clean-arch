package com.example.cleanarchitecture

import android.content.Context
import android.content.Intent

interface ActivityArgs {

    fun getIntent(context: Context): Intent
}
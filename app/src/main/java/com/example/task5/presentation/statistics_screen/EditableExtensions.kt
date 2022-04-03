package com.example.task5.presentation.statistics_screen

import android.text.Editable

fun Editable?.convertToDouble(): Double{
    return this.toString().toDouble()
}
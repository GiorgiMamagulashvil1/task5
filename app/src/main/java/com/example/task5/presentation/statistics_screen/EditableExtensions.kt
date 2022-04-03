package com.example.task5.presentation.statistics_screen

import android.text.Editable

fun Editable?.convertToInt(): Int{
    return this.toString().toInt()
}
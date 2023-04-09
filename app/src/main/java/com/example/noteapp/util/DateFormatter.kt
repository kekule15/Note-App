package com.example.noteapp.util

import java.text.SimpleDateFormat
import java.util.*

fun dateFormatter(time:Long): String {
    val date = Date(time)
    val format = SimpleDateFormat("EEE, d MMM hh:mm aaa", Locale.getDefault())

    return format.format(date)
}
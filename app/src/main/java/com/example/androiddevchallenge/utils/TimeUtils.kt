package com.example.androiddevchallenge.utils

import java.text.SimpleDateFormat
import java.util.*

//获取 年-月-日
fun long2DateString(timeStamp: Long?): String {
    if (timeStamp == 0.toLong() || timeStamp == null) return ""
    val format = SimpleDateFormat("yyyy-MM-dd")
    return if (timeStamp != null) {
        val date = Date(timeStamp)
        format.format(date)
    } else ""
}
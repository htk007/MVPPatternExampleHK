package com.hasan.myapplication.manager

import java.text.DateFormat
import java.util.Date
import java.util.Calendar

class DateCalculationManager {
    fun calculateDate(): String {
        return DateFormat.getDateTimeInstance().format(Date(Calendar.getInstance().timeInMillis))
    }
}
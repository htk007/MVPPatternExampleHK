package com.hasan.myapplication.manager

import com.hasan.myapplication.data.Session
import java.text.DateFormat
import java.util.Date
import java.util.Calendar

class DateCalculationManager {
    fun calculateDate(): String {
        return DateFormat.getDateTimeInstance().format(Date(Calendar.getInstance().timeInMillis))
    }

    fun calculateSession(): Session {
        var monthOfDate = (Calendar.getInstance().get(Calendar.MONTH) * (Calendar.getInstance().timeInMillis%24))%12
        println("CURRRRLOG current mont of date: $monthOfDate")
        var currentSession: Session
        if(monthOfDate<=3){
            currentSession =Session.AUTUMN
        }else if(monthOfDate in 4..6){
            currentSession =Session.SPRING
        }else if(monthOfDate in 7..9){
            currentSession =Session.SUMMER
        }else{
            currentSession =Session.WINTER
        }
        return currentSession
    }
}
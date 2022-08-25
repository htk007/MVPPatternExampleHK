package com.hasan.myapplication.contract

import com.hasan.myapplication.data.Session

interface MainActivityContract {
    interface View{
        fun showDate(date: String)
        fun showSession(session:Session)
        fun bindViews()
        fun initClickListeners()
    }
    interface Presenter{
        fun setView(view: View)
        fun created()
        fun onShowDateButtonClick()
        fun onShowSessionButtonOnClick()
    }
}
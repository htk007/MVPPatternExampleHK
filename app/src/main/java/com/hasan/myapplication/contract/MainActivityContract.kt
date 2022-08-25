package com.hasan.myapplication.contract

interface MainActivityContract {
    interface View{
        fun showDate(date: String)
        fun bindViews()
        fun initClickListeners()
    }
    interface Presenter{
        fun setView(view: View)
        fun created()
        fun onShowDateButtonClick()
    }
}
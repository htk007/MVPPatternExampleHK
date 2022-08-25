package com.hasan.myapplication.presenter

import com.hasan.myapplication.contract.MainActivityContract
import com.hasan.myapplication.manager.DateCalculationManager

class MainActivityPresenter(dateCalculationManager: DateCalculationManager): MainActivityContract.Presenter {

    private lateinit var mView: MainActivityContract.View
    private var mDateCalculationManager = dateCalculationManager

    override fun setView(view: MainActivityContract.View) {
        this.mView = view
    }

    override fun created() {
        this.mView.bindViews()
        this.mView.initClickListeners()
    }

    override fun onShowDateButtonClick() {
        val currentDate = this.mDateCalculationManager.calculateDate()
        this.mView.showDate(currentDate)
    }

    override fun onShowSessionButtonOnClick() {
       val currentSession = this.mDateCalculationManager.calculateSession()
        this.mView.showSession(currentSession)
    }
}
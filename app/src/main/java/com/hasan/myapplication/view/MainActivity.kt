package com.hasan.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hasan.myapplication.R
import com.hasan.myapplication.contract.MainActivityContract
import com.hasan.myapplication.manager.DateCalculationManager
import com.hasan.myapplication.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    private lateinit var tvDate: TextView
    private lateinit var btnShowDate: Button
    private lateinit var mPresenter: MainActivityPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.mPresenter = MainActivityPresenter(DateCalculationManager())
        this.mPresenter.setView(this)
        this.mPresenter.created()
    }

    override fun showDate(date: String) {
        this.tvDate.text = date
    }

    override fun bindViews() {
        this.tvDate = findViewById(R.id.tv_date)
        this.btnShowDate = findViewById(R.id.btn_show_date)
    }

    override fun initClickListeners() {
        this.btnShowDate.setOnClickListener {
            this.mPresenter.onShowDateButtonClick()
        }
    }
}
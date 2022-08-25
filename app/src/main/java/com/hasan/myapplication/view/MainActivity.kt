package com.hasan.myapplication.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.hasan.myapplication.R
import com.hasan.myapplication.contract.MainActivityContract
import com.hasan.myapplication.data.Session
import com.hasan.myapplication.manager.DateCalculationManager
import com.hasan.myapplication.presenter.MainActivityPresenter

class MainActivity : AppCompatActivity(), MainActivityContract.View {
    private lateinit var tvDate: TextView
    private lateinit var tvSession: TextView
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

    override fun showSession(session: Session) {
        when(session){
            Session.WINTER ->{
                this.tvSession.text ="WINTER"
            }
            Session.SPRING ->{
                this.tvSession.text ="SPRING"
            }
            Session.SUMMER ->{
                this.tvSession.text ="SUMMER"
            }
            Session.AUTUMN ->{
                this.tvSession.text ="AUTUMN"
            }
        }
    }

    override fun bindViews() {
        this.tvDate = findViewById(R.id.tv_date)
        this.tvSession = findViewById(R.id.tv_session)
        this.btnShowDate = findViewById(R.id.btn_show_date)
    }

    override fun initClickListeners() {
        this.btnShowDate.setOnClickListener {
            this.mPresenter.onShowDateButtonClick()
            this.mPresenter.onShowSessionButtonOnClick()
        }
    }
}
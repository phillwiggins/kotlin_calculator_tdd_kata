package com.katacalc.kotlin

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var viewModel: MainViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        attachViewModel()
        setOnClickListeners()
        setObservers()
    }

    private fun attachViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
    }

    private fun setOnClickListeners() {

        btn_plus.setOnClickListener { viewModel?.operatorPressed("+"); checkHaptic(it) }
        btn_minus.setOnClickListener { viewModel?.operatorPressed("-"); checkHaptic(it) }
        btn_multiply.setOnClickListener { viewModel?.operatorPressed("*"); checkHaptic(it) }
        btn_divide.setOnClickListener { viewModel?.operatorPressed("/"); checkHaptic(it) }
        btn_percent.setOnClickListener { viewModel?.operatorPressed("%"); checkHaptic(it) }
        btn_power.setOnClickListener { viewModel?.operatorPressed("^"); checkHaptic(it) }
        btn_root.setOnClickListener { viewModel?.operatorPressed("√"); checkHaptic(it) }

        btn_decimal.setOnClickListener { viewModel?.operatorPressed("."); checkHaptic(it) }
        btn_0.setOnClickListener { viewModel?.numberPressed(0); checkHaptic(it) }
        btn_1.setOnClickListener { viewModel?.numberPressed(1); checkHaptic(it) }
        btn_2.setOnClickListener { viewModel?.numberPressed(2); checkHaptic(it) }
        btn_3.setOnClickListener { viewModel?.numberPressed(3); checkHaptic(it) }
        btn_4.setOnClickListener { viewModel?.numberPressed(4); checkHaptic(it) }
        btn_5.setOnClickListener { viewModel?.numberPressed(5); checkHaptic(it) }
        btn_6.setOnClickListener { viewModel?.numberPressed(6); checkHaptic(it) }
        btn_7.setOnClickListener { viewModel?.numberPressed(7); checkHaptic(it) }
        btn_8.setOnClickListener { viewModel?.numberPressed(8); checkHaptic(it) }
        btn_9.setOnClickListener { viewModel?.numberPressed(9); checkHaptic(it) }

        btn_clear.setOnClickListener { viewModel?.handleClear(); checkHaptic(it) }
        btn_equals.setOnClickListener { viewModel?.handleEquals(); checkHaptic(it) }
    }

    private fun setObservers() {
        viewModel?.getFormula()?.observe(this, Observer {
            formula.text = it
        })

        viewModel?.getResult()?.observe(this, Observer {
            result.text = it
        })
    }

    private fun checkHaptic(view: View) {
        view.performHapticFeedback(5)
    }
}

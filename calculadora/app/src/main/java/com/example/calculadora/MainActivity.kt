package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity {

    private var zero: Button? = null
    private var one: Button? = null
    private var two: Button? = null
    private var three: Button? = null
    private var four: Button? = null
    private var five: Button? = null
    private var six: Button? = null
    private var seven: Button? = null
    private var eight: Button? = null
    private var nine: Button? = null
    private var add: Button? = null
    private var sub: Button? = null
    private var mul: Button? = null
    private var div: Button? = null
    private var equal: Button? = null
    private var clear: Button? = null
    private var info: TextView? = null
    private var result: TextView? = null
    private val ADDITION = '+'
    private val SUBTRACTION = '-'
    private val MULTIPLICATION = '*'
    private val DIVISION = '/'
    private val EQU = 0.toChar()
    private var val1 = Double.NaN
    private var val2 = 0.0
    private var ACTION = 0.toChar()

    protected fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupUIViews()
        zero!!.setOnClickListener { info!!.text = info!!.text.toString() + "0" }
        one!!.setOnClickListener { info!!.text = info!!.text.toString() + "1" }
        two!!.setOnClickListener { info!!.text = info!!.text.toString() + "2" }
        three!!.setOnClickListener { info!!.text = info!!.text.toString() + "3" }
        four!!.setOnClickListener { info!!.text = info!!.text.toString() + "4" }
        five!!.setOnClickListener { info!!.text = info!!.text.toString() + "5" }
        six!!.setOnClickListener { info!!.text = info!!.text.toString() + "6" }
        seven!!.setOnClickListener { info!!.text = info!!.text.toString() + "7" }
        eight!!.setOnClickListener { info!!.text = info!!.text.toString() + "8" }
        nine!!.setOnClickListener { info!!.text = info!!.text.toString() + "9" }
        sub!!.setOnClickListener {
            compute()
            ACTION = SUBTRACTION
            result!!.text = "$val1-"
            info.setText(null)
        }
        add!!.setOnClickListener {
            compute()
            ACTION = ADDITION
            result!!.text = "$val1+"
            info.setText(null)
        }
        mul!!.setOnClickListener {
            compute()
            ACTION = MULTIPLICATION
            result!!.text = "$val1*"
            info.setText(null)
        }
        div!!.setOnClickListener {
            compute()
            ACTION = DIVISION
            result!!.text = "$val1/"
            info.setText(null)
        }
        equal!!.setOnClickListener {
            compute()
            ACTION = EQU
            result!!.text = result!!.text.toString() + val2.toString() + "=" + val1.toString()
            // 5 + 4 = 9
            info.setText(null)
        }
        clear!!.setOnClickListener {
            if (info!!.text.length > 0) {
                val name: CharSequence = info!!.text.toString()
                info!!.text = name.subSequence(0, name.length - 1)
            } else {
                val1 = Double.NaN
                val2 = Double.NaN
                info.setText(null)
                result.setText(null)
            }
        }
    }

    private fun setupUIViews() {
        one = findViewById(R.id.btn1) as Button?
        zero = findViewById(R.id.btn0) as Button?
        two = findViewById(R.id.btn2) as Button?
        three = findViewById(R.id.btn3) as Button?
        four = findViewById(R.id.btn4) as Button?
        five = findViewById(R.id.btn5) as Button?
        six = findViewById(R.id.btn6) as Button?
        seven = findViewById(R.id.btn7) as Button?
        eight = findViewById(R.id.btn8) as Button?
        nine = findViewById(R.id.btn9) as Button?
        add = findViewById(R.id.btnadd) as Button?
        sub = findViewById(R.id.btnsub) as Button?
        mul = findViewById(R.id.btnmul) as Button?
        div = findViewById(R.id.btndivide) as Button?
        equal = findViewById(R.id.btnequal) as Button?
        info = findViewById(R.id.tvControl) as TextView?
        result = findViewById(R.id.tvResult) as TextView?
        clear = findViewById(R.id.btnclear) as Button?
    }

    private fun compute() {
        if (!java.lang.Double.isNaN(val1)) {
            val2 = info!!.text.toString().toDouble()
            when (ACTION) {
                ADDITION -> val1 = val1 + val2
                SUBTRACTION -> val1 = val1 - val2
                MULTIPLICATION -> val1 = val1 * val2
                DIVISION -> val1 = val1 / val2
                EQU -> {
                }
            }
        } else {
            val1 = info!!.text.toString().toDouble()
        }
    }
}
package com.example.calci

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    var digit = StringBuilder()
    var operataion: Char = ' '
    var lhs: Double = 0.0
    var rhs: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        displayRes.text = ""
        numBtn()
        opBtn()
        funBtn()
    }

    private fun numBtn(){
        oneButton.setOnClickListener { append("1") }
        twoButton.setOnClickListener { append("2") }
        threeButton.setOnClickListener { append("3") }
        fourButton.setOnClickListener { append("4") }
        fiveButton.setOnClickListener { append("5") }
        sixButton.setOnClickListener { append("6") }
        sevenButton.setOnClickListener { append("7") }
        eightButton.setOnClickListener { append("8") }
        nineButton.setOnClickListener { append("9") }
        zeroButton.setOnClickListener { append("0") }
        decimalButton.setOnClickListener { append(".") }


    }
    private  fun opBtn(){
        addButton.setOnClickListener {
            signView.text = "+"
            setectOP('A')
        }

        subtractButton.setOnClickListener {
            signView.text = "-"
            setectOP('S')
        }

        productButton.setOnClickListener {
            signView.text = "*"
            setectOP('M')
        }

        divideButton.setOnClickListener {
            signView.text = "/"
            setectOP('D')
        }
    }

    private fun setectOP(c: Char) {
         operataion = c
        if(digit.isNotEmpty()) {
            lhs = digit.toString().toDouble()
            digit.clear()
        }
    }

    private fun funBtn(){
        clearButton.setOnClickListener {
            clearScreen()
        }
        equalButton.setOnClickListener {
             if(digit.isNotEmpty() && signView.text != "")doMath()
        }
    }

    private fun clearScreen(){
        try {
            digit.deleteCharAt(digit.length-1)
            displayRes.text = digit.toString()
        }
        catch (E:Exception){
            displayRes.text = ""
        }
    }

    private fun doMath(){
        rhs = digit.toString().toDouble()
        digit.clear()

        when(operataion){
            'A'->{
                val x :Double = mathHelper.add(lhs,rhs)
                displayRes.text = x.toString()
                digit.append(x)
            }
            'S'->{
                val x :Double = mathHelper.sub(lhs,rhs)
                displayRes.text = x.toString()
                digit.append(x)
            }
            'M'->{
                val x :Double = mathHelper.mul(lhs,rhs)
                displayRes.text = x.toString()
                digit.append(x)
            }
            'D'->{
                val x :Double = mathHelper.div(lhs,rhs)
                displayRes.text = x.toString()
                digit.append(x)
            }
        }
        signView.text = ""
    }

    private fun append(str :String){
        digit.append(str)
        displayRes.text = digit.toString()
    }
}


class mathHelper{
    companion object{
        fun add(lhs:Double ,rhs:Double) :Double{
            return lhs + rhs
        }
        fun sub(lhs:Double ,rhs:Double) :Double{
            return lhs - rhs
        }
        fun mul(lhs:Double ,rhs:Double) :Double{
            return lhs * rhs
        }
        fun div(lhs:Double ,rhs:Double) :Double{
            return lhs / rhs
        }
    }
}


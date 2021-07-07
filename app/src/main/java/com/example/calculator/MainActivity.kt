package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import net.objecthunter.exp4j.ExpressionBuilder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Numbers
        tvOne.setOnClickListener { appendOnExpresstion("1", true) }
        tvTwo.setOnClickListener { appendOnExpresstion("2", true) }
        tvThree.setOnClickListener { appendOnExpresstion("3", true) }
        tvFour.setOnClickListener { appendOnExpresstion("4", true) }
        tvFive.setOnClickListener { appendOnExpresstion("5", true) }
        tvSix.setOnClickListener { appendOnExpresstion("6", true) }
        tvSeven.setOnClickListener { appendOnExpresstion("7", true) }
        tvEight.setOnClickListener { appendOnExpresstion("8", true) }
        tvNine.setOnClickListener { appendOnExpresstion("9", true) }
        tvZero.setOnClickListener { appendOnExpresstion("0", true) }
        tvDot.setOnClickListener { appendOnExpresstion(".", true) }

        //Operators
        tvPlus.setOnClickListener { appendOnExpresstion("+", false) }
        tvMinus.setOnClickListener { appendOnExpresstion("-", false) }
        tvMul.setOnClickListener { appendOnExpresstion("*", false) }
        tvDivide.setOnClickListener { appendOnExpresstion("/", false) }
        tv100.setOnClickListener { appendOnExpresstion("%", false) }

        tvClear.setOnClickListener {
            tvExpression.text = ""
            tvResult.text = ""
        }



        tvResult.text = ""

        tvEquals.setOnClickListener {



            try {

                val expression = ExpressionBuilder(tvExpression.text.toString()).build()
                val result = expression.evaluate()
                val longResult = result.toLong()
                if(result == longResult.toDouble())
                    tvResult.text = longResult.toString()
                else
                    tvResult.text = result.toString()

            }catch (e:Exception){
                Log.d("Exception"," message : " + e.message )
            }

            //new code
            if(tvExpression.text=="69")
            {
                tvResult.text="FUCK YOU"
            }
        }

    }

    private fun appendOnExpresstion(s: String, b: Boolean) {

        if(tvResult.text.isNotEmpty()){
            tvExpression.text = ""
        }

        if (b) {
            tvResult.text = ""
            tvExpression.append(s)
        } else {
            tvExpression.append(tvResult.text)
            tvExpression.append(s)
            tvResult.text = ""
        }

    }
}
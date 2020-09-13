package com.example.firstkotlinproject

import android.app.Activity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    public var option: String = "+"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val opts = resources.getStringArray(R.array.actions)

        if (spinner != null)
        {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opts)
            spinner.adapter = adapter

            spinner.onItemSelectedListener = object :
                AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: android.view.View, position: Int, id: Long) {
                    option = opts[position]
                }

                override fun onNothingSelected(parent: AdapterView<*>) {
                    option = "+"
                }
            }
        }

        button2.setOnClickListener {
            calculate()
        }
    }

    private fun calculate()
    {
        val first = editTextNumber3.text.toString().toInt()
        val second = editTextNumber4.text.toString().toInt()
        var result: Int
        result = when (option) {
            "+" -> {
                first + second
            }
            "-" -> {
                first - second
            }
            "*" -> {
                first * second
            }
            else -> {
                if (second != 0)
                    first / second
                else
                    0
            }
        }
        resultText.text = result.toString()
    }
}

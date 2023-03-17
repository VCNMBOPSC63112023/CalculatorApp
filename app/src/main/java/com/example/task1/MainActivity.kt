package com.example.task1

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.Math.sqrt

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonAddition = findViewById<Button>(R.id.buttonAddition)

        val buttonSubtraction = findViewById<Button>(R.id.buttonSubtraction)

        val buttonDivision = findViewById<Button>(R.id.buttonDivision)

        val buttonMultiply = findViewById<Button>(R.id.buttonMultiply)

        val textViewDisplay = findViewById<TextView>(R.id.textViewDisplay)

        val editTextNumber1 = findViewById<EditText>(R.id.editTextNumber1)

        val editTextNumber2 = findViewById<EditText>(R.id.editTextNumber2)

        val buttonSquare = findViewById<Button>(R.id.buttonSquare)

        val buttonPower = findViewById<Button>(R.id.buttonPower)

        val textViewError = findViewById<TextView>(R.id.textViewError)

        val buttonStats = findViewById<Button>(R.id.buttonStats)

        buttonAddition?.setOnClickListener {

            //var display: String = ""

            var total: Number

            var number1 = editTextNumber1.text.toString().toInt()

            var number2 = editTextNumber2.text.toString().toInt()

            total = number1 + number2
            textViewDisplay.text = "${number1} + ${number2} = ${total}"

            textViewError.text = " "
        }

        buttonSubtraction?.setOnClickListener {

            //var display: String = ""

            var total: Number

            var number1 = editTextNumber1.text.toString().toInt()

            var number2 = editTextNumber2.text.toString().toInt()

            total = number1 - number2
            textViewDisplay.text = "${number1} - ${number2} = ${total}"

            textViewError.text = " "
        }

        buttonDivision?.setOnClickListener {

            //var display: String = ""

            var total: Number

            var number1 = editTextNumber1.text.toString().toInt()

            var number2 = editTextNumber2.text.toString().toInt()

            if (number2 == 0) {
                textViewError.text = "Error encounted: You cannot divide by zero."

                textViewError.setTextColor(Color.parseColor("red"))

                textViewDisplay.text = " "
            } else {
                total = number1 / number2

                textViewDisplay.text = "${number1} / ${number2} = ${total}"
            }

        }

        buttonMultiply?.setOnClickListener {

            //var display: String = ""

            var total: Number

            var number1 = editTextNumber1.text.toString().toInt()

            var number2 = editTextNumber2.text.toString().toInt()

            total = number1 * number2
            textViewDisplay.text = "${number1} * ${number2} = ${total}" //w3schools, 2022

            textViewError.text = " "
        }

        buttonSquare?.setOnClickListener {

            var total: Number

            var sqaure: Number

            var number1 = editTextNumber1.text.toString().toInt()

            if (number1 < 0)
            {
                //Math.abs(number1)

                sqaure = number1 - number1 - number1

                total = Math.sqrt(sqaure.toDouble())

                textViewDisplay.text = "sqrt($number1) = ${total} i"

            } else {
                total = Math.sqrt(number1.toDouble())

                textViewDisplay.text = "sqrt($number1) = ${total}" //w3schools, 2022

                textViewError.text = " "
            }

        }

        buttonPower?.setOnClickListener {

            val base = editTextNumber1.text.toString().toInt()

            var power = editTextNumber2.text.toString().toInt()

            var powerOf = editTextNumber2.text.toString().toInt()

            var result: Long = 1

            while (power != 0) {
                result *= base.toLong()
                --power
            }

            textViewDisplay.text = "${base} ^ ${powerOf} = ${result}"

            textViewError.text = " "
        }

        buttonStats?.setOnClickListener {
            val intent = Intent(this, StatisticsFunctions::class.java)
            startActivity(intent) // in text reference
        }
    }
}
//full reference
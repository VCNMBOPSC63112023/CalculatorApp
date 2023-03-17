package com.example.task1

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.util.*

class StatisticsFunctions : AppCompatActivity() {

    var numbers = arrayListOf<Int>(0,0,0,0,0,0,0,0,0,0) // array

    var counter = 0 // array counter

    var numberIn = 0 // variable to set the count end number in

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistics_functions)

        val editTextNumber = findViewById<EditText>(R.id.editTextNumber)

        val buttonAdding = findViewById<Button>(R.id.buttonAdding)

        val buttonClear = findViewById<Button>(R.id.buttonClear)

        val buttonAverage = findViewById<Button>(R.id.buttonAverage)

        val buttonMinMax = findViewById<Button>(R.id.buttonMinMax)

        val textViewShow = findViewById<TextView>(R.id.textViewShow)

        val textViewAnswer2 = findViewById<TextView>(R.id.textViewAnswer2)

        val textViewErrors = findViewById<TextView>(R.id.textViewErrors)

        buttonAdding?.setOnClickListener {

            var max = 10 // max number of values allowed
            var count = 0 // loop counter to output array list

            var space: String = " " // space to add between outputting array list

            var array = editTextNumber.text.toString().toInt() // getting the input from the user

            var temp = "" // temp variable to output numbers

                numbers[counter] = array // setting user input into the array
                counter++ // incrementing the array

                while (count < max) { // loop to output the numbers in the array

                    temp += "${numbers[count]}" + space // output
                    count++ // increment count to output next value

                }

                numberIn = counter // setting counter end value to variable for later

                textViewShow.text = "${temp}" // setting text view to temp
                editTextNumber.setText("") // clear field to enter new numbers

                if (counter == max) {
                    textViewErrors.text = "You cannot input more than 10 numbers"
                    textViewErrors.setTextColor(Color.parseColor("red"))
                }
            }


        buttonClear?.setOnClickListener {
            textViewShow.setText("")
            textViewErrors.setText("")
            numbers = arrayListOf<Int>(0,0,0,0,0,0,0,0,0,0)
            counter = 0
            textViewAnswer2.setText("")

        }

        buttonAverage?.setOnClickListener {

            var count1 = 0
            var limit = numberIn

            var final = 0

            var total = 0

            var average = 0

            textViewErrors.setText("")

            while (count1 != limit) {

                average += numbers[count1]
                count1++
            }

            final = average / limit

            total = final
            textViewAnswer2.text = "the average is: ${total}"
        }

        buttonMinMax?.setOnClickListener {

            var largest = numbers[0]
            var smallest = numbers[0]

            for (num in numbers) {
                if (largest < num)
                    largest = num
            }

            for (num in numbers) {
                if (smallest > num)
                    smallest = num
            }

            textViewAnswer2.text = ("MAX: ${largest} MIN: ${smallest}")

        }

    }
}
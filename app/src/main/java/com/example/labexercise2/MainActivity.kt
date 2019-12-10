package com.example.labexercise2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calculateButton : Button = findViewById(R.id.buttonCalculate)
        val resetButton : Button = findViewById(R.id.buttonReset)

        calculateButton.setOnClickListener{calculateBMI()}
        resetButton.setOnClickListener{reset()}
    }

    private fun calculateBMI(){
        val getWeight : EditText = findViewById(R.id.editTextWeight)
        val getHeight : EditText = findViewById(R.id.editTextHeight)

        val weight = getWeight.text.toString().toDouble()
        val height = getHeight.text.toString().toDouble() / 100

        val total = weight /(height*height)

        textViewBMI.text = "BMI : $total"

        if(total <= 18.5){
            imageViewProfile.setImageResource(R.drawable.under)
        }

        if(total in 18.5..24.9){
            imageViewProfile.setImageResource(R.drawable.normal)
        }

        if(total >= 25){
            imageViewProfile.setImageResource(R.drawable.over)
        }
    }

    private fun reset(){
        editTextHeight.setText("")
        editTextWeight.setText("")
        textViewBMI.text = ""
        imageViewProfile.setImageResource(R.drawable.empty)
    }
}

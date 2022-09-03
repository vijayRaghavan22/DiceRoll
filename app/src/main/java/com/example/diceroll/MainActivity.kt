package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myFirstDice = Dice(4,"MyFirstDice")
        val luckyNumber=4
        val rollButton : Button = findViewById(R.id.button)
        val myViewIs : TextView = findViewById(R.id.textView)
        val diceViewIs : ImageView = findViewById(R.id.diceView)

        /*
         *  Register a onClick Listener event on diceRoll Button
         *  set Dice Drawable resource in ImageView
         *  set Message in textView
         */
        rollButton.setOnClickListener {
            val rollResult=myFirstDice.diceRoll()
            setDiceImage(rollResult, diceViewIs)
            setDiceRollMessage(rollResult, luckyNumber, myViewIs)
        }
    }

    // Method to set appropriate alert message on screen
    private fun setDiceRollMessage(rollResult: Int,luckyNumber: Int,myViewIs: TextView)
    {
        when (rollResult) {
            luckyNumber -> {
                myViewIs.text = "You WIN its a ${rollResult.toString()}";
                println("Winner found");
            };
            1 -> myViewIs.text = "So sorry! You rolled a 1. Try again!";
            2 -> myViewIs.text = "Sadly, you rolled a 2. Try again!"
            3 -> myViewIs.text = "Unfortunately, you rolled a 3. Try again!"
            5 -> myViewIs.text = "Don't cry! You rolled a 5. Try again!"
            6 -> myViewIs.text = "Apologies! You rolled a 6. Try again!"
        }
    }

    // method to set appropriate dice image on screen
    private fun setDiceImage(rollResult: Int, diceViewIs: ImageView) {
        val uri = "dice_$rollResult"
        println("URI is:  $uri")
        val res =
            ContextCompat.getDrawable(this, resources.getIdentifier(uri, "drawable", packageName))
        diceViewIs.setImageDrawable(res)
    }
}
package com.example.diceroll

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat

private const val TAG = "MainActivity";

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
            Log.v(TAG,"Button to roll Dice Clicked");
            val rollResult=myFirstDice.diceRoll()
            Log.v(TAG,"Button to roll Dice Clicked and result is $rollResult");
            setDiceImage(rollResult, diceViewIs)
            setDiceRollMessage(rollResult, luckyNumber, myViewIs)
        }
    }

    // Method to set appropriate alert message on screen
    private fun setDiceRollMessage(rollResult: Int,luckyNumber: Int,myViewIs: TextView)
    {
        try {
            when (rollResult) {
                luckyNumber -> {
                    myViewIs.text = "You WIN its a ${rollResult.toString()}";
                    Log.i( TAG,"Winner found");
                };
                1 -> myViewIs.text = "So sorry! You rolled a 1. Try again!";
                2 -> myViewIs.text = "Sadly, you rolled a 2. Try again!"
                3 -> myViewIs.text = "Unfortunately, you rolled a 3. Try again!"
                5 -> myViewIs.text = "Don't cry! You rolled a 5. Try again!"
                6 -> myViewIs.text = "Apologies! You rolled a 6. Try again!"
            }
        }catch (ex: Exception){
            Log.e(TAG,"Exception occurred during textView being populated")
        }
    }

    // method to set appropriate dice image on screen
    private fun setDiceImage(rollResult: Int, diceViewIs: ImageView) {
        val uri = "dice_$rollResult"
        Log.i(TAG,"Inside setDiceImage function and Name of drawable is:  $uri")
        val res =
            ContextCompat.getDrawable(this, resources.getIdentifier(uri, "drawable", packageName))
        diceViewIs.setImageDrawable(res)
    }
}
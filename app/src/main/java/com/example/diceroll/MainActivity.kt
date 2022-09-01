package com.example.diceroll

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var myFIrstDice : Dice = Dice(4,"MyFIrstDice");
        val luckyNumber=4;

        val rollButton : Button = findViewById(R.id.button);
        rollButton.setOnClickListener {
            val myViewIs : TextView = findViewById(R.id.textView);
            val rollResult=myFIrstDice.diceRoll();
            when(rollResult){
                luckyNumber -> {
                    myViewIs.text="You WIN its a ${rollResult.toString()}";
                    println("Winner found");
                };
                1 -> myViewIs.text= "So sorry! You rolled a 1. Try again!";
                2 -> myViewIs.text= "Sadly, you rolled a 2. Try again!"
                3 -> myViewIs.text= "Unfortunately, you rolled a 3. Try again!"
                5 -> myViewIs.text= "Don't cry! You rolled a 5. Try again!"
                6 -> myViewIs.text= "Apologies! You rolled a 6. Try again!"
            }
        }
    }
}
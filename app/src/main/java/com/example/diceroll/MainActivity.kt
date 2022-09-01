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

        val rollButton : Button = findViewById(R.id.button);
        rollButton.setOnClickListener {
            val myViewIs : TextView = findViewById(R.id.textView);
            myViewIs.text= myFIrstDice.diceRoll().toString();
        }
    }
}
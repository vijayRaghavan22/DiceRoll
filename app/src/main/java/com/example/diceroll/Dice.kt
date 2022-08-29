package com.example.diceroll

class Dice {
    private val sides: Int;
    private var name: String="UNKNOWN";

    constructor(sides:Int=6){
        this.sides=sides;
    }

    constructor(sides:Int=6,name:String="UNKNOWN"){
        this.name=name;
        this.sides=sides;
    }
    fun diceRoll(): Int{
        return (1..sides).random();
    }
}
package com.example.diceroll

import org.junit.Assert.assertTrue
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    private val testDiceObj=Dice(6,"testDice");
    @Test
    fun testDiceROll(){
        assertTrue("Dice Rolled and output is between 1 and 6 ",testDiceObj.diceRoll() in 1..6);
    }

}
package org.frittenbude.day02

import org.junit.Assert
import org.junit.Test
import java.io.File

class IntcodeComputerTest{

    @Test
    fun solveFirstQuest(){
        val input = File("src/test/resources/input02.txt").readText().trim(',').split(',').map { Integer.parseInt(it) }.toCollection(ArrayList())
        val result = IntcodeComputer().compute(input)
        println("result: " + result[0])
    }

    @Test
    fun solveSecondQuiz(){
        val input = File("src/test/resources/input02.txt").readText().trim(',').split(',').map { Integer.parseInt(it) }.toCollection(ArrayList())
        for(i in 0 .. 99){
            for(j in 0 .. 99){
                // set first parameter to i
                input[1] = i
                // set second paramter to j
                input[2] = j
                // compute result
                val result = IntcodeComputer().compute(input)[0]
                if(result == 19690720){
                    println("solved! a=$i, b=$j, result=${100*i + j}")
                    return
                }
            }
        }
        println("Could not find a solution :(")
    }

    @Test
    fun computeAddTest(){
        val input = arrayListOf(1,5,6,0,99,10,20)
        val result = IntcodeComputer().compute(input)
        Assert.assertSame(30, result[0])
    }

    @Test
    fun computeMultiplyTest(){
        val input = arrayListOf(2,5,6,0,99,5,8)
        val result = IntcodeComputer().compute(input)
        Assert.assertSame(40, result[0])
    }

    @Test
    fun computeTest1(){
        val input = arrayListOf(1,0,0,0,99)
        val result = IntcodeComputer().compute(input)
        Assert.assertSame(2, result[0])
    }

    @Test
    fun computeTest4(){
        val input = arrayListOf(1,1,1,4,99,5,6,0,99)
        val result = IntcodeComputer().compute(input)
        Assert.assertSame(30, result[0])
    }
}
package org.frittenbude.day05

import org.junit.Test
import java.io.File

class AdvancedIntcodeComputerTest{
    @Test
    fun test(){
        AdvancedIntcodeComputer().compute(listOf(3,21,1008,21,8,20,1005,20,22,107,8,21,20,1006,20,31,
            1106,0,36,98,0,0,1002,21,125,20,4,20,1105,1,46,104,
            999,1105,1,46,1101,1000,1,20,4,20,1105,1,46,98,99).toMutableList())
    }

    @Test
    fun printSolutionA(){
        val instructions = File("src/test/resources/input05.txt").readLines()[0].trim(',').split(',').map { Integer.parseInt(it) }.toList()
        AdvancedIntcodeComputer().compute(instructions)
    }
}
package org.frittenbude.day05

import org.junit.Test
import java.io.File

class AdvancedIntcodeComputerTest{
    @Test
    fun test(){
        AdvancedIntcodeComputer().compute(listOf(3,3,1002,7,3,7,4,7,99,33).toMutableList())
    }

    @Test
    fun printSolutionA(){
        val instructions = File("src/test/resources/input05.txt").readLines()[0].trim(',').split(',').map { Integer.parseInt(it) }.toList()
        AdvancedIntcodeComputer().compute(instructions)
    }
}
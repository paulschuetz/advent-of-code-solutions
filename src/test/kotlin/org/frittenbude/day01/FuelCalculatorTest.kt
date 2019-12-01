package org.frittenbude.day01

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.stream.Collectors


class FuelCalculatorTest{
    @Test
    fun testCalculateFuel(){
        val fuel = FuelCalculator().calculateFuel(arrayListOf(10, 15, 8 ))
        Assert.assertSame(4, fuel)
    }

    @Test
    fun printSolution(){
        val components = File("src/test/resources/input01.txt").readLines().toList().stream().map { Integer.parseInt(it) }.collect(Collectors.toList())
        println(FuelCalculator().calculateFuel(components))
    }
}
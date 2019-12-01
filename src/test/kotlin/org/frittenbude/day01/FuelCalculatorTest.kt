package org.frittenbude.day01

import org.junit.Assert
import org.junit.Test
import java.io.File
import java.util.stream.Collectors


class FuelCalculatorTest{

    @Test
    fun printSolution01(){
        val components = File("src/test/resources/input01.txt").readLines().toList().stream().map { Integer.parseInt(it) }.collect(Collectors.toList())
        println(FuelCalculator().calculateFuelForComponents(components))
    }

    @Test
    fun printSolution02(){
        val components = File("src/test/resources/input01.txt").readLines().toList().stream().map { Integer.parseInt(it) }.collect(Collectors.toList())
        println(FuelCalculator().calculateTotalFuelForComponents(components))
    }

    @Test
    fun testCalculateFuel(){
        val fuel = FuelCalculator().calculateFuelForComponents(arrayListOf(10, 15, 8 ))
        Assert.assertSame(4, fuel)
    }

    // I literally have no clue while this is failing although the results are identical
    @Test
    fun testCalculateTotalFuelForComponent(){
        val totalFuel = FuelCalculator().calculateTotalFuelForComponent(1969)
        Assert.assertSame("TotalFuelForComponent", 966, totalFuel)
    }
}
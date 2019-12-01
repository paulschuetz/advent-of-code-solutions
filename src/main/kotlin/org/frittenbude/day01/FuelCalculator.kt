package org.frittenbude.day01

class FuelCalculator{
    fun calculateFuel(components: List<Int>) : Int {
        return components.stream().mapToInt{ (it / 3) - 2 }.sum()
    }
}
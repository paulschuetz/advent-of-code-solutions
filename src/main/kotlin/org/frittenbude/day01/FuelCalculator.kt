package org.frittenbude.day01

class FuelCalculator{

    private fun calculateFuelForComponent(componentMass: Int) : Int {
        return (componentMass / 3) - 2
    }

    fun calculateFuelForComponents(components: List<Int>) : Int {
        return components.stream().mapToInt{ calculateFuelForComponent(it) }.sum()
    }

    fun calculateTotalFuelForComponents(components: List<Int>) : Int{
        return components.stream().mapToInt{ calculateTotalFuelForComponent(it) }.sum()
    }

    fun calculateTotalFuelForComponent(component: Int) : Int {
        val fuel = calculateFuelForComponent(component)
        return if(fuel < 0) 0
        else fuel + calculateTotalFuelForComponent(fuel)
    }
}
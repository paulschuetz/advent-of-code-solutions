package org.frittenbude.day06

import org.junit.Test
import java.io.File

class OrbitChecksumTest {
    @Test
    fun test() {
        print(
            OrbitChecksum().calculateChecksum(
                listOf(
                    Orbit("A", "B"),
                    Orbit("C", "D"),
                    Orbit("C", "G"),
                    Orbit("B", "C"),
                    Orbit("F", "H")
                )
            )
        )
    }

    @Test
    fun printSolutionA(){
        val orbits = File("src/test/resources/input06.txt").readLines().map {
            Orbit(
                it.split(')')[0],
                it.split(')')[1]
            )
        }.toList()
        print(OrbitChecksum().calculateChecksum(orbits))
    }

    @Test
    fun printSolutionB(){
        val orbits = File("src/test/resources/input06.txt").readLines().map {
            Orbit(
                it.split(')')[0],
                it.split(')')[1]
            )
        }.toList()
        print(OrbitChecksum().countOrbitalTransfers(orbits))
    }

}
package org.frittenbude.day03

import org.junit.Test
import java.io.File

class FindWireIntersectionTest{

    @Test
    fun solveQuizA(){
        val path1 = File("src/test/resources/input03.txt").readLines()[0].trim(',').split(',').map { WirePathFactory.fromInput(it) }.toList()
        val path2 = File("src/test/resources/input03.txt").readLines()[1].trim(',').split(',').map { WirePathFactory.fromInput(it) }.toList()
        val result = FindWireIntersection().findIntersection(path1, path2)
        print("nearest intersection distance: $result")
    }

    @Test
    fun testExample(){
        // R8,U5,L5,D3
        val wirePathA = listOf(WirePath(Direction.RIGHT, 8), WirePath(Direction.UP, 5), WirePath(Direction.LEFT, 5), WirePath(Direction.DOWN, 3))
        // U7,R6,D4,L4
        val wirePathB = listOf(WirePath(Direction.UP, 7), WirePath(Direction.RIGHT, 6), WirePath(Direction.DOWN, 4), WirePath(Direction.LEFT, 4))
        val optDistance = FindWireIntersection().findIntersection(wirePathA, wirePathB)
        println("Optimal distance is: $optDistance")
    }
}
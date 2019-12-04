package org.frittenbude.day03

import java.lang.RuntimeException

enum class Direction{
    RIGHT, LEFT, UP, DOWN
}

data class WirePath(val direction: Direction, val length: Int)

class WirePathFactory{
    companion object {
        fun fromInput(input: String): WirePath{
            val directionInitial = input.elementAt(0)
            val direction = when(directionInitial){
                'R' -> Direction.RIGHT
                'L' -> Direction.LEFT
                'U' -> Direction.UP
                'D' -> Direction.DOWN
                else -> throw RuntimeException("merry x-mas")
            }
            val length = Integer.parseInt(input.substring(1))
            return WirePath(direction, length)
        }
    }
}
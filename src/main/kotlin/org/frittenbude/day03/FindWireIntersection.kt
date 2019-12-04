package org.frittenbude.day03

class FindWireIntersection{
    fun findIntersection(wirePathsA: List<WirePath>, wirePathsB: List<WirePath>): Int{
        val visitedCoordinates = HashMap<Int, HashMap<Int, Boolean>>()

        var x = 0
        var y = 0

        for (path in wirePathsA) {
            when (path.direction) {
                Direction.DOWN -> {
                    for (yCoord in (y - path.length) .. y) {
                        visitedCoordinates.getOrPut(x) { HashMap() }.getOrPut(yCoord) { true }
                    }
                    y -= path.length
                }
                Direction.UP -> {
                    for (yCoord in y .. (y + path.length) ) {
                        visitedCoordinates.getOrPut(x) { HashMap() }.getOrPut(yCoord) { true }
                    }
                    y += path.length
                }
                Direction.LEFT -> {
                    for (xCoord in (x - path.length) .. x ) {
                        visitedCoordinates.getOrPut(xCoord) { HashMap() }.getOrPut(y) { true }
                    }
                    x -= path.length
                }
                Direction.RIGHT -> {
                    for (xCoord in x .. (x + path.length)  ) {
                        visitedCoordinates.getOrPut(xCoord) { HashMap() }.getOrPut(y) { true }
                    }
                    x += path.length
                }
            }

        }
        // now we got our map and need all intersections
        var optDistance = Integer.MAX_VALUE
        x = 0
        y = 0

        for (path in wirePathsB) {
            when (path.direction) {
                Direction.DOWN -> {
                    for (yCoord in (y - path.length) until y) {
                        if(visitedCoordinates.getOrDefault(x, HashMap()).getOrDefault(yCoord, false)){
                            if(Math.abs(x) + Math.abs(yCoord) < optDistance) optDistance = Math.abs(x) + Math.abs(yCoord)
                        }
                    }
                    y -= path.length
                }
                Direction.UP -> {
                    for (yCoord in y+1 .. (y + path.length) ) {
                        if(visitedCoordinates.getOrDefault(x, HashMap()).getOrDefault(yCoord, false)){
                            if(Math.abs(x) + Math.abs(yCoord) < optDistance) optDistance = Math.abs(x) + Math.abs(yCoord)
                        }
                    }
                    y += path.length
                }
                Direction.LEFT -> {
                    for (xCoord in (x - path.length) until x) {
                        if(visitedCoordinates.getOrDefault(xCoord, HashMap()).getOrDefault(y, false)){
                            if(Math.abs(xCoord) + Math.abs(y) < optDistance) optDistance = Math.abs(xCoord) + Math.abs(y)
                        }
                    }
                    x -= path.length
                }
                Direction.RIGHT -> {
                    for (xCoord in x+1 .. (x + path.length)  ) {
                        if(visitedCoordinates.getOrDefault(xCoord, HashMap()).getOrDefault(y, false)){
                            if(Math.abs(xCoord) + Math.abs(y) < optDistance) optDistance = Math.abs(xCoord) + Math.abs(y)
                        }
                    }
                    x += path.length
                }
            }

        }
        return optDistance
    }
}
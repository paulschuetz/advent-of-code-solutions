package org.frittenbude.day08

import java.lang.Exception


/**
 * Inspired by https://github.com/0legg/adventofcode/blob/master/src/main/kotlin/net/olegg/aoc/year2019/day8/Day8.kt because he got mad skills
 */
class ImageDecoder{

    fun checkForCorruption(pixels: List<Int>) : Int{
        return pixels.chunked(LAYER_SIZE)
            .minBy { layer ->  layer.count { it == 0 }}
            .orEmpty()
            .let { layer -> layer.count { it == 1 } * layer.count { it == 2} }
    }


    fun drawImage(pixels: List<Int>){
        val transparent = List(25 * 6) { 2 }
        val picture = pixels.chunked(LAYER_SIZE)
            .fold(transparent) { acc, layer -> acc.zip(layer) {top, bottom -> if (top == 2) bottom else top}}
            .map { when(it){
                0 -> "  "
                1 -> "XX"
                2 -> "  "
                else -> throw Exception("Unknown pixel code.")
            } }

        picture.chunked(WIDTH).forEach { row ->
            row.forEach { pixel ->
                print(pixel)
            }
            println()
        }
    }

    companion object {
        private const val WIDTH  = 25
        private const val HEIGHT = 6
        private const val LAYER_SIZE = WIDTH * HEIGHT
    }
}
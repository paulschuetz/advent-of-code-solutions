package org.frittenbude.day08

class ImageDecoder{

    fun checkForCorruption(pixels: List<Int>) : Int{
        return pixels.chunked(LAYER_SIZE)
            .minBy { layer ->  layer.count { it == 0 }}
            .orEmpty()
            .let { layer -> layer.count { it == 1 } * layer.count { it == 2} }
    }

    companion object {
        private const val WIDTH  = 25
        private const val HEIGHT = 6
        private const val LAYER_SIZE = WIDTH * HEIGHT
    }
}